package br.com.tiagocrais.publi.api.service.model.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class ViaCepDtoResponse {

    @JsonProperty
    private String cep;

    @JsonProperty
    private String logradouro;

    @JsonProperty
    private String complemento;

    @JsonProperty
    private String bairro;

    @JsonProperty
    private String localidade;

    @JsonProperty
    private String uf;

    @JsonProperty
    private String ibge;

    @JsonProperty
    private String gia;

    @JsonProperty
    private String ddd;

    @JsonProperty
    private String siafi;
}
