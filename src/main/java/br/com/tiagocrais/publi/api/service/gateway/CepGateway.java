package br.com.tiagocrais.publi.api.service.gateway;

import br.com.tiagocrais.publi.api.service.model.response.ViaCepDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.netty.http.client.HttpClient;

import java.net.URI;

@Service
public class CepGateway {

    private WebClient webClient;

    private String viaCepHost = "https://viacep.com.br/";

    private String viaCepPath = "ws/";

    private static final Logger logger = LoggerFactory.getLogger(CepGateway.class);

    public ViaCepDtoResponse consultarCepPorId(Integer cep) {

        ViaCepDtoResponse response = new ViaCepDtoResponse();

        logger.info("Iniciando chamada em {}{} com o CEP: {}", viaCepHost, viaCepPath, cep);

        URI uri = UriComponentsBuilder.fromHttpUrl(viaCepHost.concat(viaCepPath).concat(cep.toString().concat("/json/")))
                .build()
                .toUri();

        return getWebClient().get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ViaCepDtoResponse.class)
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
