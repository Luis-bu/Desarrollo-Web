package co.javeriana.dw.thymeleaf.Formulario.service;

import co.javeriana.dw.thymeleaf.Formulario.Contact;
import co.javeriana.dw.thymeleaf.repository.ContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repo;

    public ContactServiceImpl(ContactRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Contact guardar(Contact registro) {
        return repo.save(registro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> traerTodos() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> buscarPorCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }
}
