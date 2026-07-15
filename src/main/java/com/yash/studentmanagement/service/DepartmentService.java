package com.yash.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.studentmanagement.entity.Department;
import com.yash.studentmanagement.repository.DepartmentRepository;

@Service
public class DepartmentService 
{

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) 
    {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) 
    {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() 
    {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) 
    {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteDepartment(Long id) 
    {
        departmentRepository.deleteById(id);
    }
}