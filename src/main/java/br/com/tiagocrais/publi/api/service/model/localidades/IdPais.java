package br.com.tiagocrais.publi.api.service.model.localidades;

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
public class IdPais {

    @JsonProperty("M49")
    private Integer m49;

    @JsonProperty("ISO-ALPHA-2")
    private String isoAlpha2;

    @JsonProperty("ISO-ALPHA-3")
    private String isoAlpha3;
}
