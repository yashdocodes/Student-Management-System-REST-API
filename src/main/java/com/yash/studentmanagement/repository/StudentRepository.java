package com.yash.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{
}