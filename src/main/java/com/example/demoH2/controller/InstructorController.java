package com.example.demoH2.controller;

import com.example.demoH2.model.Instructor;
import com.example.demoH2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
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


    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")

    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Integer id) {
        boolean isDeleted = instructorService.deleteInstructor(id);

        if (isDeleted) {
            return ResponseEntity.ok("Instructor eliminado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor con ID " + id + " no encontrado.");
        }
    }

}
