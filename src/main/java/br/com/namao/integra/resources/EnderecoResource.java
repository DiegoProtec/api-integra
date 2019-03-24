package br.com.namao.integra.resources;

import br.com.namao.integra.models.entity.Endereco;
import br.com.namao.integra.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/enderecos")
@RequiredArgsConstructor
@RestController
public class EnderecoResource {

    private final EnderecoService enderecoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Endereco>> lista() {
        return ResponseEntity.ok(enderecoService.listar().collect(Collectors.toList()));
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> endereco(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

}
