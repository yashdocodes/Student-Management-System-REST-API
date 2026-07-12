package com.yash.studentmanagement.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/page")
    public Page<Student> getStudents(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sortBy,
        @RequestParam String direction)
    {
    return studentService.getStudents(page, size, sortBy, direction);
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
    @GetMapping("/search")
    public List<Student> searchStudentByName(@RequestParam String name) 
    {
    return studentService.searchStudentByName(name);
    }
    @GetMapping("/search/contains")
    public List<Student> searchStudentByNameContaining(@RequestParam String name) 
    {
    return studentService.searchStudentByNameContaining(name);
    }
    @GetMapping("/search/ignorecase")
    public List<Student> searchStudentByNameContainingIgnoreCase(@RequestParam String name) 
    {
    return studentService.searchStudentByNameContainingIgnoreCase(name);
    }
    @GetMapping("/age")
    public List<Student> getStudentsByAge(@RequestParam Integer age) 
    {
    return studentService.getStudentsByAge(age);
    }

    @GetMapping("/age/greater")
    public List<Student> getStudentsByAgeGreaterThan(@RequestParam Integer age) 
    {
    return studentService.getStudentsByAgeGreaterThan(age);
    }

    @GetMapping("/age/less")
    public List<Student> getStudentsByAgeLessThan(@RequestParam Integer age) 
    {
    return studentService.getStudentsByAgeLessThan(age);
    }
}