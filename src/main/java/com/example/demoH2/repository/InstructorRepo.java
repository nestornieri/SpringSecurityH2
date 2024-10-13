package com.example.demoH2.repository;

import com.example.demoH2.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepo extends CrudRepository<Instructor,Integer> {
}
