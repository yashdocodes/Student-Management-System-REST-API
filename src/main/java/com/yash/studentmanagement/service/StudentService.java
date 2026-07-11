package com.yash.studentmanagement.service;

import java.util.List;

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
}