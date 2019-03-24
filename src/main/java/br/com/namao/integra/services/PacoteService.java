package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Pacote;
import br.com.namao.integra.repositorys.PacoteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacoteService extends AbstractCrudService<Pacote, Long, PacoteRepository> {

    PacoteService(PacoteRepository repository) {
        super(repository);
    }

}
