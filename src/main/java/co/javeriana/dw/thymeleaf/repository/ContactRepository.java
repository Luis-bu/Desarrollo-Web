package co.javeriana.dw.thymeleaf.repository;

import co.javeriana.dw.thymeleaf.Formulario.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByCorreo(String correo);
}
