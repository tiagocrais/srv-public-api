package br.com.tiagocrais.publi.api.service.usecase;

import br.com.tiagocrais.publi.api.service.gateway.CepGateway;
import br.com.tiagocrais.publi.api.service.model.response.CepResponse;
import br.com.tiagocrais.publi.api.service.model.response.ViaCepDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepUseCase {

    @Autowired
    CepGateway cepGateway;

    private static final Logger logger = LoggerFactory.getLogger(CepUseCase.class);

    public CepResponse consultarCepPorId(Integer cep) {

        ViaCepDtoResponse retorno = cepGateway.consultarCepPorId(cep);
        logger.info("Retorno da consulta do CEP: {} COM O endereço: {}", cep, retorno);

        return mapper(retorno);
    }

    private CepResponse mapper(ViaCepDtoResponse retorno) {

        return CepResponse.builder()
                .cep(retorno.getCep())
                .rua(retorno.getLogradouro())
                .complemento(retorno.getComplemento())
                .bairro(retorno.getBairro())
                .cidade(retorno.getLocalidade())
                .estado(retorno.getUf())
                .ddd(retorno.getDdd())
                .build();
    }
}
