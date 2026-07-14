package com.yash.studentmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yash.studentmanagement.entity.Passport;
import com.yash.studentmanagement.entity.Student;
import com.yash.studentmanagement.exception.ResourceNotFoundException;
import com.yash.studentmanagement.repository.PassportRepository;
import com.yash.studentmanagement.repository.StudentRepository;

@Service
public class StudentService 
{

    private final StudentRepository studentRepository;
    private final PassportRepository passportRepository;

    public StudentService(StudentRepository studentRepository, PassportRepository passportRepository) 
    {
        this.studentRepository = studentRepository;
        this.passportRepository = passportRepository;
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

    Student existingStudent = studentRepository.findById(id).orElseThrow(() ->
    new ResourceNotFoundException("Student not found with ID: " + id));
    existingStudent.setName(updatedStudent.getName());
    existingStudent.setAge(updatedStudent.getAge());

    return studentRepository.save(existingStudent);
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
    public List<Student> getAllStudentsJPQL() 
    {
    return studentRepository.getAllStudentsJPQL();
    }

    public List<Student> findStudentByName(String name) 
    {
    return studentRepository.findStudentByName(name);
    }   

    public List<Student> searchStudent(String keyword) 
    {
    return studentRepository.searchStudent(keyword);
    }

    public List<Student> findStudentsAgeGreaterThan(int age) 
    {
    return studentRepository.findStudentsAgeGreaterThan(age);
    }

    public List<Student> findStudentsAgeLessThan(int age) 
    {
    return studentRepository.findStudentsAgeLessThan(age);
    }
    public List<Student> findStudentByNamePosition(String name) 
    {
    return studentRepository.findStudentByNamePosition(name);
    }

    public List<Student> getStudentsOrderByAgeDesc() 
    {
    return studentRepository.getStudentsOrderByAgeDesc();
    }

    public long countStudents() 
    {
    return studentRepository.countStudents();
    }

    public Integer getMaximumAge() 
    {
    return studentRepository.getMaximumAge();
    }

    public Integer getMinimumAge() 
    {
    return studentRepository.getMinimumAge();
    }

    public Double getAverageAge() 
    {
    return studentRepository.getAverageAge();
    }
    public int updateStudentAge(Integer id, Integer age) 
    {
    return studentRepository.updateStudentAge(id, age);
    }

    public int deleteStudentsAgeLessThan(Integer age) 
    {
    return studentRepository.deleteStudentsAgeLessThan(age);
    }

    public Student assignPassportToStudent(Integer studentId, Long passportId)
    {
    Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));

    Passport passport = passportRepository.findById(passportId).orElseThrow(() -> new ResourceNotFoundException("Passport not found with ID: " + passportId));

    student.setPassport(passport);

    return studentRepository.save(student);
    }
}