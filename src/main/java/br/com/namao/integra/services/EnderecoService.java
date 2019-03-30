package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.Endereco;
import br.com.namao.integra.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends AbstractCrudService<Endereco, Long, EnderecoRepository> {

    EnderecoService(EnderecoRepository repository) {
        super(repository);
    }

}
