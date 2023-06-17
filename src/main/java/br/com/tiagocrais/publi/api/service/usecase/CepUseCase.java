package br.com.tiagocrais.publi.api.service.usecase;

import br.com.tiagocrais.publi.api.service.exception.CepNotFoundException;
import br.com.tiagocrais.publi.api.service.gateway.CepGateway;
import br.com.tiagocrais.publi.api.service.model.request.EnderecoRequest;
import br.com.tiagocrais.publi.api.service.model.response.CepResponse;
import br.com.tiagocrais.publi.api.service.model.response.ViaCepDtoResponse;
import br.com.tiagocrais.publi.api.service.utils.UfEstadoDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CepUseCase {

    @Autowired
    CepGateway cepGateway;

    @Autowired
    UfEstadoDictionary ufEstadoDictionary;

    private static final Logger logger = LoggerFactory.getLogger(CepUseCase.class);

    public CepResponse consultarCepPorId(Integer cep) {

        ViaCepDtoResponse retorno = cepGateway.consultarCepPorId(cep);
        logger.info("Retorno da consulta do CEP: {} com o endereço: {}", cep, retorno);

        if (retorno.getCep() == null) {
            throw new CepNotFoundException("Cep retornou null!");
        }

        return mapper(retorno);
    }

    public List<CepResponse> consultarCepPorEndereco(EnderecoRequest request) {

        List<ViaCepDtoResponse> retorno = cepGateway.consultarCepPorEndereco(request);
        logger.info("Retorno da consulta com o(s) endereço(s): {}", retorno);

        if (isListCepNaoEncontrado(retorno)) {
            throw new CepNotFoundException("Ceps retornaram null!");
        };
        return mapperList(retorno);

    }

    private CepResponse mapper(ViaCepDtoResponse retorno) {

        return CepResponse.builder()
                .cep(retorno.getCep())
                .rua(retorno.getLogradouro())
                .complemento(retorno.getComplemento())
                .bairro(retorno.getBairro())
                .cidade(retorno.getLocalidade())
                .estado(ufEstadoDictionary.obterEstado(retorno.getUf()))
                .ddd(retorno.getDdd())
                .build();
    }

    private List<CepResponse> mapperList(List<ViaCepDtoResponse> listViaCepResponse) {

        List<CepResponse> listCepResponse = new ArrayList<>();
        for (ViaCepDtoResponse viaCepResponse : listViaCepResponse) {
            CepResponse cepResponse = CepResponse.builder()
                    .cep(viaCepResponse.getCep())
                    .rua(viaCepResponse.getLogradouro())
                    .complemento(viaCepResponse.getComplemento())
                    .bairro(viaCepResponse.getBairro())
                    .cidade(viaCepResponse.getLocalidade())
                    .estado(ufEstadoDictionary.obterEstado(viaCepResponse.getUf()))
                    .ddd(viaCepResponse.getDdd())
                    .build();
            listCepResponse.add(cepResponse);
        }

        return listCepResponse;
    }

    public boolean isListCepNaoEncontrado(List<ViaCepDtoResponse> retorno) {

        for (ViaCepDtoResponse viaCepDtoResponse : retorno) {
            if (viaCepDtoResponse.getCep() != null) {
                return false;
            }
        }
        return true;
    }
}
