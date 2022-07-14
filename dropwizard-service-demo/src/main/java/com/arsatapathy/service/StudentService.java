package com.arsatapathy.service;

import com.arsatapathy.model.Student;
import com.arsatapathy.repo.StudentRepo;
import com.google.inject.Inject;

import java.util.Optional;

public class StudentService {

    private StudentRepo studentRepo;

    @Inject
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> getStudent(String id) {
        return studentRepo.getStudent(id);
    }

    public void saveStudent(Student student) {
        studentRepo.saveStudent(student);
    }

}
