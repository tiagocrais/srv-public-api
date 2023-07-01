package br.com.tiagocrais.publi.api.service.controller;

import br.com.tiagocrais.publi.api.service.model.request.PaisRequest;
import br.com.tiagocrais.publi.api.service.model.response.PaisesIbgeResponse;
import br.com.tiagocrais.publi.api.service.usecase.LocalidadesUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadesController {

    @Autowired
    private LocalidadesUseCase localidadesUseCase;

    private static final Logger logger = LoggerFactory.getLogger(LocalidadesController.class);

    @GetMapping("/paises")
    public List<PaisesIbgeResponse> consultarPaises(@RequestParam("pais") List<String> paises) {

        List<PaisRequest> paisesConsultados = paises.stream()
                .map(pais -> PaisRequest.builder().nome(pais).build())
                .collect(Collectors.toList());

        logger.info("Recebendo requisição em /api/localidades/paises e inciando chamada com request: paises: {}", paisesConsultados);
        return localidadesUseCase.consultarPaises(paisesConsultados);
    }
}
