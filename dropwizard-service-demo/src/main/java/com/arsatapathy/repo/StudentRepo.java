package com.arsatapathy.repo;

import com.arsatapathy.model.Student;

import java.util.Optional;

public interface StudentRepo {

    public Optional<Student> getStudent(String id);
    public void saveStudent(Student student);

}
