package br.com.tiagocrais.publi.api.service.controller;

import br.com.tiagocrais.publi.api.service.model.request.EnderecoRequest;
import br.com.tiagocrais.publi.api.service.model.response.CepResponse;
import br.com.tiagocrais.publi.api.service.usecase.CepUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/consulta/cep")
public class CepController {

    @Autowired
    private CepUseCase cepUseCase;

    private static final Logger logger = LoggerFactory.getLogger(CepController.class);

    @GetMapping("/{id}")
    public CepResponse consultarCep(@PathVariable Integer id) {

        logger.info("Recebendo requisição em /api/consulta/cep e inciando chamada com request: CEP {}", id);
        return cepUseCase.consultarCepPorId(id);
    }

    @GetMapping("/{uf}/{cidade}/{logradouro}")
    public List<CepResponse> consultarEndereco(
            @PathVariable String uf,
            @PathVariable String cidade,
            @PathVariable String logradouro) {

        EnderecoRequest request = new EnderecoRequest(uf, cidade, logradouro);

        logger.info("Recebendo requisição em /api/consulta/cep e inciando chamada com request: uf: {}, cidade: {}, logradouro: {}", uf, cidade, logradouro);
        return cepUseCase.consultarCepPorEndereco(request);
    }
}
