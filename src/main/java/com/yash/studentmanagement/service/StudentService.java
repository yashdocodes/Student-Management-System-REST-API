package com.yash.studentmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yash.studentmanagement.entity.Student;
import com.yash.studentmanagement.exception.ResourceNotFoundException;
import com.yash.studentmanagement.repository.StudentRepository;

@Service
public class StudentService 
{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) 
    {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) 
    {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() 
    {
        return studentRepository.findAll();
    }
    public Student getStudentById(Integer id) 
    {
    return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
    }
    public Student updateStudent(Integer id, Student updatedStudent) 
    {

    Student existingStudent = studentRepository.findById(id).orElse(null);

    if (existingStudent != null) 
    {

        existingStudent.setName(updatedStudent.getName());

        existingStudent.setAge(updatedStudent.getAge());

        return studentRepository.save(existingStudent);
    }

    return null;
    }
    public void deleteStudent(Integer id) 
    {
    studentRepository.deleteById(id);
    }
    public Page<Student> getStudents(int page, int size, String sortBy, String direction)
    {
    Pageable pageable = PageRequest.of(
        page,
        size,
        Sort.by(Sort.Direction.fromString(direction), sortBy)
    );

    return studentRepository.findAll(pageable);
    }
    public List<Student> searchStudentByName(String name) 
    {
    return studentRepository.findByName(name);
    }
    public List<Student> searchStudentByNameContaining(String name) 
    {
    return studentRepository.findByNameContaining(name);
    }
    public List<Student> searchStudentByNameContainingIgnoreCase(String name) 
    {
    return studentRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Student> getStudentsByAge(Integer age) 
    {
    return studentRepository.findByAge(age);
    }

    public List<Student> getStudentsByAgeGreaterThan(Integer age) 
    {
    return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> getStudentsByAgeLessThan(Integer age) 
    {
    return studentRepository.findByAgeLessThan(age);
    }
}