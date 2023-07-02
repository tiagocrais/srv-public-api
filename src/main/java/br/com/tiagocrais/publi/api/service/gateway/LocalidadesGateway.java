package br.com.tiagocrais.publi.api.service.gateway;

import br.com.tiagocrais.publi.api.service.exception.LocalidadesException;
import br.com.tiagocrais.publi.api.service.model.response.PaisesIbgeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    private static final String ERROR_CODE_SERVICO_IBGE = "SERVICO_IBGE";

    private static final String ERROR_CODE_SRV = "SRV-500";

    private static final Logger logger = LoggerFactory.getLogger(LocalidadesGateway.class);

    public List<PaisesIbgeResponse> consultarPaises() {

        try {

            logger.info("Iniciando chamada em {}", servicoDadosIbgeHost);
            URI uri = UriComponentsBuilder.fromHttpUrl(servicoDadosIbgeHost).build().toUri();

            return getWebClient().get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<PaisesIbgeResponse>>() {})
                    .block();

        } catch (LocalidadesException e) {

            logger.error("ERRO: {} - {}", servicoDadosIbgeHost, e);
            throw new LocalidadesException(
                    e.getMessage(),
                    ERROR_CODE_SERVICO_IBGE + e.getStatusCode(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value());

        } catch (Exception e) {

            logger.error("ERRO: {} - {}", servicoDadosIbgeHost, e);
            throw new LocalidadesException(
                    e.getMessage(),
                    ERROR_CODE_SRV,
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
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
