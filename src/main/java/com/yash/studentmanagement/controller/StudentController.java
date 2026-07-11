package com.yash.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.studentmanagement.entity.Student;
import com.yash.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController 
{

    private final StudentService studentService;

    public StudentController(StudentService studentService) 
    {
        this.studentService = studentService;
    }

    @PostMapping
    public Student saveStudent(@Valid @RequestBody Student student) 
    {
    return studentService.saveStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() 
    {
    return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) 
    {
    return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                            @Valid @RequestBody Student student) 
                            {
                                return studentService.updateStudent(id, student);
                            }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) 
    {
    studentService.deleteStudent(id);
    }
}