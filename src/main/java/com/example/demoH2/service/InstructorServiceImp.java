package com.example.demoH2.service;

import com.example.demoH2.model.Instructor;
import com.example.demoH2.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class InstructorServiceImp implements InstructorService{
    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    @Transactional(readOnly=true)
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>)instructorRepo.findAll();
    }

}
