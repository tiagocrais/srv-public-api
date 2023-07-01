package br.com.tiagocrais.publi.api.service.gateway;

import br.com.tiagocrais.publi.api.service.model.response.PaisesIbgeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.util.List;

@Service
public class LocalidadesGateway {

    private WebClient webClient;

    private String servicoDadosIbgeHost = "https://servicodados.ibge.gov.br/api/v1/localidades/paises";

    private static final Logger logger = LoggerFactory.getLogger(LocalidadesGateway.class);

    public List<PaisesIbgeResponse> consultarPaises() {

        logger.info("Iniciando chamada em {}", servicoDadosIbgeHost);
        URI uri = UriComponentsBuilder.fromHttpUrl(servicoDadosIbgeHost).build().toUri();

        return getWebClient().get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<PaisesIbgeResponse>>() {})
                .block();
    }

    public WebClient getWebClient() {
        if (webClient == null) {
            webClient = WebClient.builder()
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .clientConnector(new ReactorClientHttpConnector(HttpClient.create()))
                    .build();
        }

        return webClient;
    }
}
