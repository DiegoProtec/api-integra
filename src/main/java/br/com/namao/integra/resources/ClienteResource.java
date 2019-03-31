package br.com.namao.integra.resources;

import br.com.namao.integra.models.entities.Cliente;
import br.com.namao.integra.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/clientes")
@RequiredArgsConstructor
@RestController
public class ClienteResource {

    private final ClienteService clienteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> lista() {
        return ResponseEntity.ok(clienteService.listar().collect(Collectors.toList()));
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cliente(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

}
