package br.com.namao.integra.resources;

import br.com.namao.integra.models.entity.Item;
import br.com.namao.integra.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/itens")
@RequiredArgsConstructor
@RestController
public class ItemResource {

    private final ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> lista() {
        return ResponseEntity.ok(itemService.listar().collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> item(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }

}
