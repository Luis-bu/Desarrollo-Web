package co.javeriana.dw.thymeleaf.Formulario;

import co.javeriana.dw.thymeleaf.Formulario.service.ContactService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/formulario")
public class ContactController {

    private final ContactService servicio;

    public ContactController(ContactService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String verPagina(Model model) {
        model.addAttribute("registro", new Contact());
        model.addAttribute("buzon", servicio.traerTodos());
        model.addAttribute("activeTab", "formulario");
        return "formulario";
    }

    @PostMapping
    public String enviar(@ModelAttribute("registro") Contact registro, Model model) {

        servicio.guardar(registro);

        model.addAttribute("registro", new Contact());
        model.addAttribute("buzon", servicio.traerTodos());
        model.addAttribute("activeTab", "formulario");
        model.addAttribute("successMessage", "Listo ✅ Tu mensaje quedó guardado.");
        return "formulario";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Contact> apiListar() {
        return servicio.traerTodos();
    }

    @PostMapping("/delete/{id}")
    public String borrar(@PathVariable("id") Long id) {
        servicio.eliminarPorId(id);
        return "redirect:/formulario";
    }
}
