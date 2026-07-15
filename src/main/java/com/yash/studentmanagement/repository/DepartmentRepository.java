package com.yash.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.studentmanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> 
{
}