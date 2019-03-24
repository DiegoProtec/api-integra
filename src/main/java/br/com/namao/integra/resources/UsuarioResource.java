package br.com.namao.integra.resources;

import br.com.namao.integra.models.entity.Usuario;
import br.com.namao.integra.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/usuarios")
@RequiredArgsConstructor
@RestController
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> lista() {
        return ResponseEntity.ok(usuarioService.listar().collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> usuario(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

}
