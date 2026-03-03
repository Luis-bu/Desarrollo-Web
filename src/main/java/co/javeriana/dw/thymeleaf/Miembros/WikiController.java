package co.javeriana.dw.thymeleaf.Miembros;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikiController {

    @GetMapping("/")
    public String home() {
        return "redirect:/proyecto";
    }

    @GetMapping("/proyecto")
    public String project(Model model) {
        model.addAttribute("tituloProyecto", "WikiPR");
        model.addAttribute(
                "resumen",
                "WikiPR es un mini‑sitio hecho con Spring Boot + Thymeleaf para documentar un proyecto: descripción, equipo y arquitectura (MVC)."
        );
        model.addAttribute("activeTab", "proyecto");
        return "proyecto";
    }

    @GetMapping("/miembros")
    public String members(Model model) {
        model.addAttribute("activeTab", "miembros");

        model.addAttribute("integrantes", List.of(
                new Member(1, "Luis Bueno", "Backend & Arquitectura", "luis.bueno@correo.com"),
                new Member(2, "Daniel Felipe", "Frontend (Thymeleaf)", "daniel.felipe@correo.com"),
                new Member(3, "Jeison Camilo", "DevOps & Deploy", "jeison.camilo@correo.com"),
                new Member(4, "Juan", "QA & Pruebas", "juan@correo.com"),
                new Member(5, "Juanes Nonsoque", "Base de Datos (PostgreSQL)", "juanes.nonsoque@correo.com")
        ));

        return "miembros";
    }

    @GetMapping("/arquitectura")
    public String architecture(Model model) {
        model.addAttribute("activeTab", "arquitectura");
        return "arquitectura";
    }
}
