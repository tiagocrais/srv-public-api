package br.com.tiagocrais.publi.api.service.model.response;


import br.com.tiagocrais.publi.api.service.model.localidades.IdPais;
import br.com.tiagocrais.publi.api.service.model.localidades.RegiaoIntermediariaPaises;
import br.com.tiagocrais.publi.api.service.model.localidades.SubRegiao;
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
public class PaisesIbgeResponse {

    private IdPais id;

    private String nome;

    @JsonProperty("regiao-intermediaria")
    private RegiaoIntermediariaPaises regiaoIntermediaria;

    @JsonProperty("sub-regiao")
    private SubRegiao subRegiao;
}
