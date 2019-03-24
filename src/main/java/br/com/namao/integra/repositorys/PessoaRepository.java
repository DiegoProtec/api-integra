package br.com.namao.integra.repositorys;

import br.com.namao.integra.models.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
