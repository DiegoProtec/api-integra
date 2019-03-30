package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.Telefone;
import br.com.namao.integra.repositories.TelefoneRepository;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService extends AbstractCrudService<Telefone, Long, TelefoneRepository> {

    TelefoneService(TelefoneRepository repository) {
        super(repository);
    }

}
