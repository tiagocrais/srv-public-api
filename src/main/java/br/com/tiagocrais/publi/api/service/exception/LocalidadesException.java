package br.com.tiagocrais.publi.api.service.exception;

public class LocalidadesException extends ExceptionBase {

    public LocalidadesException() {
    }

    public LocalidadesException(String message, String errorCode, Integer httpStatusCode) {

        this.setStatusCode(httpStatusCode);
        this.setErrorCode(errorCode);
        this.setMessage(message);
    }

    public LocalidadesException(String errorCode, Integer httpStatusCode) {

        this.setStatusCode(httpStatusCode);
        this.setErrorCode(errorCode);
    }
}
