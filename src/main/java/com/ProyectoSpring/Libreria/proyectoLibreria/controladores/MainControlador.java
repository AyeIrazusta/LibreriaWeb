
package com.ProyectoSpring.Libreria.proyectoLibreria.controladores;

import com.ProyectoSpring.Libreria.proyectoLibreria.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainControlador {
    
    @Autowired
    private AutorServicio autorServicio;
    
        
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
