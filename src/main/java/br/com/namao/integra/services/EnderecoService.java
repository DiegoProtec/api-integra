package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Endereco;
import br.com.namao.integra.repositories.EnderecoRepository;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends AbstractCrudService<Endereco, Long, EnderecoRepository> {

    EnderecoService(EnderecoRepository repository) {
        super(repository);
    }

    @Override
    public Endereco buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CustomNotFound("Endereco, código: " + id + ", não encontrado."));
    }

}