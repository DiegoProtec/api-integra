package br.com.namao.integra.repositorys;

import br.com.namao.integra.models.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
