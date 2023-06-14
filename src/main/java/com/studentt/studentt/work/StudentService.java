package com.studentt.studentt.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name) {
        Student student = studentRepository.findById(id).orElseThrow();
            if (name != null && name.length() > 0 && !student.getName().equals(name)) {
                student.setName(name);
            }
    }
}
