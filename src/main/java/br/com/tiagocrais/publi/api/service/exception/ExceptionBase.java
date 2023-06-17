package br.com.tiagocrais.publi.api.service.exception;

import lombok.Getter;
import lombok.Setter;

public class ExceptionBase extends RuntimeException {

    @Getter
    @Setter
    private Integer statusCode;

    @Getter
    @Setter
    private String errorCode;

    @Getter
    @Setter
    private String message;
}
