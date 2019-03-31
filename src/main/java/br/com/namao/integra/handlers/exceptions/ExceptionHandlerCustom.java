package br.com.namao.integra.handlers.exceptions;

import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerCustom extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFound.class)
    public ResponseEntity<ErrorMessage> resourceNotFound(RuntimeException ex, WebRequest request) {
        System.out.println(request.getContextPath());
        ErrorMessage msg = new ErrorMessage(
                request.getContextPath() + "http://errors.namao.com.br/integra/404",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }


}
