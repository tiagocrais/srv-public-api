package br.com.tiagocrais.publi.api.service.usecase;

import br.com.tiagocrais.publi.api.service.gateway.LocalidadesGateway;
import br.com.tiagocrais.publi.api.service.model.request.PaisRequest;
import br.com.tiagocrais.publi.api.service.model.response.PaisesIbgeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadesUseCase {

    @Autowired
    LocalidadesGateway localidadesGateway;

    private static final Logger logger = LoggerFactory.getLogger(LocalidadesUseCase.class);

    public List<PaisesIbgeResponse> consultarPaises(List<PaisRequest> paises) {

        List<PaisesIbgeResponse> retornoIbge = localidadesGateway.consultarPaises();
        logger.info("Retorno da consulta com os paises: {}", retornoIbge);

        List<PaisesIbgeResponse> paisesFiltrados = retornoIbge.stream()
                .filter(paisIbgeResponse -> paises.stream()
                        .anyMatch(paisRequest -> paisRequest.getNome().equals(paisIbgeResponse.getNome())))
                .collect(Collectors.toList());
        logger.info("Paises filtrados: {} ", paisesFiltrados);

        return paisesFiltrados;
    }
}
