package com.example.demoH2.service;

import com.example.demoH2.model.Instructor;
import com.example.demoH2.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImp implements InstructorService{
    @Autowired
    private InstructorRepo instructorRepository;

    @Override
    @Transactional(readOnly=true)
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>)instructorRepository.findAll();
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> getInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Integer id, Instructor instructor) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor updatedInstructor = existingInstructor.get();
            updatedInstructor.setNombre(instructor.getNombre());
            updatedInstructor.setApellidos(instructor.getApellidos());
            updatedInstructor.setSalario(instructor.getSalario());
            return instructorRepository.save(updatedInstructor);
        } else {
            throw new RuntimeException("Instructor not found with id: " + id);
        }
    }

    @Override
    public boolean deleteInstructor(Integer id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (instructor.isPresent()) {
            instructorRepository.delete(instructor.get());
            return true;
        } else {
            return false;
        }
    }

}
