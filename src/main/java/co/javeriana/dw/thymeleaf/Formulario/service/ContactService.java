package co.javeriana.dw.thymeleaf.Formulario.service;

import co.javeriana.dw.thymeleaf.Formulario.Contact;
import java.util.List;
import java.util.Optional;

public interface ContactService {

    Contact guardar(Contact registro);

    List<Contact> traerTodos();

    Optional<Contact> buscarPorCorreo(String correo);

    void eliminarPorId(Long id);
}
