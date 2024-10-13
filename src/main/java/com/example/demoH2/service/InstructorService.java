package com.example.demoH2.service;

import com.example.demoH2.model.Instructor;

import java.util.Collection;


public interface InstructorService {
    public abstract Collection<Instructor> findAll();
}
