package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStudent() {
        return studentRepository.findAll();
    }

    public List<Student> findByPaymentFalse() {
        return studentRepository.findByPaymentFalse();
    }

    public List<Student> findStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public List<Student> findStudentBySurname(String surname){
        return studentRepository.findBySurname(surname);
    }

    public List<Student> findStudentByGroupName(int groupNumber){
        return studentRepository.findByGroupNumber(groupNumber);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(int id){
        return studentRepository.findById(id);
    }
}
