package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Item;
import br.com.namao.integra.repositories.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractCrudService<Item, Long, ItemRepository> {

    ItemService(ItemRepository repository) {
        super(repository);
    }

}
