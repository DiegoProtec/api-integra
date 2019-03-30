package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.EmailEntity;
import br.com.namao.integra.repositories.EmailRepository;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

@Service
public class EmailService extends AbstractCrudService<EmailEntity, Long, EmailRepository> {

    EmailService(EmailRepository repository) {
        super(repository);
    }

    @Override
    public EmailEntity buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CustomNotFound("Email, código: " + id + ", não encontrado."));
    }

}
