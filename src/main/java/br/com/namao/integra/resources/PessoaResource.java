package br.com.namao.integra.resources;

import br.com.namao.integra.models.entity.Pessoa;
import br.com.namao.integra.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;


@RequestMapping("/pessoas")
@RequiredArgsConstructor
@RestController
public class PessoaResource {

    private final PessoaService pessoaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pessoa>> lista() {
        return ResponseEntity.ok(pessoaService.listar().collect(toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> pessoa(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

}


