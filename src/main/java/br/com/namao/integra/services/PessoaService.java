package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Pessoa;
import br.com.namao.integra.repositorys.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends AbstractCrudService<Pessoa, Long, PessoaRepository> {

    PessoaService(PessoaRepository repository) {
        super(repository);
    }

}
