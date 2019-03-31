package br.com.namao.integra.handlers.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorMessage implements Serializable {

    private static final long serialVersionUID = -8377067875423383293L;

    private String titulo;
    private String mensagem;
    private int status;
    private Long timestamp;

    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    ErrorMessage(String titulo, String mensagem, int status, Long timestamp) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
        this.timestamp = timestamp;
    }

}
