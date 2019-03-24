package br.com.namao.integra.advices;

import br.com.namao.integra.advices.exceptions.CustomNotFound;
import br.com.namao.integra.advices.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerNotFound extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFound.class)
    public ResponseEntity<ErrorMessage> resourceNotFound(RuntimeException ex, WebRequest request) {
        LocalDateTime now = LocalDateTime.now();
        ErrorMessage msg = new ErrorMessage(
                "http://errors.namao.com.br/integra/404",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }

}
