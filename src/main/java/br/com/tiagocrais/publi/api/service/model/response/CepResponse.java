package br.com.tiagocrais.publi.api.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CepResponse {

    private String cep;

    private String rua;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String ddd;
}
