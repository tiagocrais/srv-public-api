package br.com.tiagocrais.publi.api.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoRequest {

    private String uf;

    private String cidade;

    private String logradouro;
}
