package com.example.demoH2.service;

import com.example.demoH2.model.Instructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface InstructorService {
    public abstract Collection<Instructor> findAll();


    List<Instructor> getAllInstructors();
    Optional<Instructor> getInstructorById(Integer id);
    Instructor createInstructor(Instructor instructor);
    Instructor updateInstructor(Integer id, Instructor instructor);
    boolean deleteInstructor(Integer id);

}
