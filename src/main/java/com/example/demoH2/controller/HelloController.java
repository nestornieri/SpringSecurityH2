package com.example.demoH2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String saludar() 	{
        return "new ResponseEntity<>(itemsInstructor,HttpStatus.OK);";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna el nombre de la vista de la página de inicio de sesión (login.html)
    }
}
