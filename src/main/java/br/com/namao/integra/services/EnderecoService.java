package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Endereco;
import br.com.namao.integra.repositorys.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends AbstractCrudService<Endereco, Long, EnderecoRepository> {

    EnderecoService(EnderecoRepository repository) {
        super(repository);
    }

}
