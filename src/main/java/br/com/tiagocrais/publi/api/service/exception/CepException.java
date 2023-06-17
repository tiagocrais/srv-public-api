package br.com.tiagocrais.publi.api.service.exception;

public class CepException extends ExceptionBase {

    public CepException() {
    }

    public CepException(String message, String errorCode, Integer httpStatusCode) {

        this.setStatusCode(httpStatusCode);
        this.setErrorCode(errorCode);
        this.setMessage(message);
    }

    public CepException(String errorCode, Integer httpStatusCode) {

        this.setStatusCode(httpStatusCode);
        this.setErrorCode(errorCode);
    }
}
