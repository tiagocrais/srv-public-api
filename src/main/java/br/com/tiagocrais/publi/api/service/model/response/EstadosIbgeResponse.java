package br.com.tiagocrais.publi.api.service.model.response;

import br.com.tiagocrais.publi.api.service.model.localidades.Regiao;
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
public class EstadosIbgeResponse {

    private Integer id;

    private String nome;

    private String sigla;

    private Regiao regiao;
}
