package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByPaymentFalse();

    List<Student> findByName(String name);

    List<Student> findBySurname(String surname);

    List<Student> findByGroupNumber(int groupNumber);

    void deleteById(int id);

    Student save(Student student);

    Student findById(int id);
}
