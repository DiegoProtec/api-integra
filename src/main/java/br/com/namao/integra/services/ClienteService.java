package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.Cliente;
import br.com.namao.integra.repositories.ClienteRepository;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractCrudService<Cliente, Long, ClienteRepository> {

    ClienteService(ClienteRepository repository) {
        super(repository);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CustomNotFound("Cliente, código: " + id + ", não encontrado."));
    }

}