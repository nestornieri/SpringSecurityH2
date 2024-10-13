package com.example.demoH2.controller;

import com.example.demoH2.model.Instructor;
import com.example.demoH2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/listar_public")
    public ResponseEntity<?> listarPUBLIC() 	{
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }

    @GetMapping("/listar_admin")
    public ResponseEntity<?> listarADMIN() {
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }

    @GetMapping("/listar_user")
    public ResponseEntity<?> listarUSER() {
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }


}
