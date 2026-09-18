package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long nextId = 1L;

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudentById(Long id) {
        if (!students.containsKey(id)) {
            throw new IllegalArgumentException("Student not found with id: " + id);
        }
        return students.get(id);
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(nextId++);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (!students.containsKey(id)) {
            throw new IllegalArgumentException("Student not found with id: " + id);
        }

        student.setId(id);
        students.put(id, student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        if (!students.containsKey(id)) {
            throw new IllegalArgumentException("Student not found with id: " + id);
        }
        students.remove(id);
    }
}
