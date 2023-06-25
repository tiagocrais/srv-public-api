package br.com.tiagocrais.publi.api.service.model.response;

import br.com.tiagocrais.publi.api.service.model.localidades.Municipio;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DistritosIbgeResponse {

    private Integer id;

    private String nome;

    private Municipio municipio;
}
