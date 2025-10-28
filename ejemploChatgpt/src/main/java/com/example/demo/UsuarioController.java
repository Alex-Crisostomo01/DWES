package com.example.demo;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }
}

