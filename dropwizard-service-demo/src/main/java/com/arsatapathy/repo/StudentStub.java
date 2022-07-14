package com.arsatapathy.repo;

import com.arsatapathy.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class StudentStub implements StudentRepo {
    private Map<String, Student> map = new HashMap<>();

    public StudentStub() {
        map.put("123",
                Student.builder()
                        .id("123")
                        .firstName("ashish")
                        .lastName("satapathy")
                        .age(30).build());
    }

    public Optional<Student> getStudent(String rollNumber) {
        Student student = map.get(rollNumber);

        if (!Objects.isNull(student))
            return Optional.of(student);
        else
            return Optional.empty();
    }

    public void saveStudent(Student student) {
        map.put(student.getId(), student);
    }
}
