package br.com.namao.integra.resources;

import br.com.namao.integra.models.entities.Usuario;
import br.com.namao.integra.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuarios")
@RequiredArgsConstructor
@RestController
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> usuario(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

}
