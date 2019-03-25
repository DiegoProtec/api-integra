package br.com.namao.integra.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFound extends RuntimeException {

    public CustomNotFound(String message) {
        super(message);
    }

}
