package br.com.tiagocrais.publi.api.service.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException(String mensagem) {
        super(mensagem);
    }
}
