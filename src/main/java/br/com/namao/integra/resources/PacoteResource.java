package br.com.namao.integra.resources;

import br.com.namao.integra.models.entity.Pacote;
import br.com.namao.integra.services.PacoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pacotes")
@RequiredArgsConstructor
@RestController
public class PacoteResource {

    private final PacoteService pacoteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pacote>> lista() {
        return ResponseEntity.ok(pacoteService.listar().collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pacote> pessoa(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(pacoteService.buscarPorId(id));
    }

}
