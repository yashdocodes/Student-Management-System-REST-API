package com.yash.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> 
{
    List<Student> findByName(String name);
    List<Student> findByNameContaining(String name);
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByAge(Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
}