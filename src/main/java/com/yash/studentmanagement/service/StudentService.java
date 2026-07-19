package com.yash.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yash.studentmanagement.dto.CourseResponseDTO;
import com.yash.studentmanagement.dto.DepartmentResponseDTO;
import com.yash.studentmanagement.dto.PassportResponseDTO;
import com.yash.studentmanagement.dto.StudentRequestDTO;
import com.yash.studentmanagement.dto.StudentResponseDTO;
import com.yash.studentmanagement.entity.Course;
import com.yash.studentmanagement.entity.Department;
import com.yash.studentmanagement.entity.Passport;
import com.yash.studentmanagement.entity.Student;
import com.yash.studentmanagement.exception.ResourceNotFoundException;
import com.yash.studentmanagement.repository.CourseRepository;
import com.yash.studentmanagement.repository.DepartmentRepository;
import com.yash.studentmanagement.repository.PassportRepository;
import com.yash.studentmanagement.repository.StudentRepository;

@Service
public class StudentService 
{

    private final StudentRepository studentRepository;
    private final PassportRepository passportRepository;
    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, PassportRepository passportRepository, 
    DepartmentRepository departmentRepository, CourseRepository courseRepository, ModelMapper modelMapper) 
    {
        this.studentRepository = studentRepository;
        this.passportRepository = passportRepository;
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }


    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) 
    {
        Student student = convertToEntity(requestDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToResponseDTO(savedStudent);
    }
    public List<StudentResponseDTO> getAllStudents() 
    {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToResponseDTO).toList();
    }
    public StudentResponseDTO getStudentById(Integer id) 
    {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return convertToResponseDTO(student);
    }
    public StudentResponseDTO updateStudent(Integer id, StudentRequestDTO requestDTO) 
    {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        Student updatedStudent = studentRepository.save(student);
        return convertToResponseDTO(updatedStudent);
    }
    public void deleteStudent(Integer id) 
    {
        studentRepository.deleteById(id);
    }
    public Page<Student> getStudents(int page, int size, String sortBy, String direction)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy)
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

    public Student assignDepartment(Integer studentId, Long departmentId) 
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        student.setDepartment(department);
        return studentRepository.save(student);
    }

    public Student enrollCourse(Integer studentId, Long courseId) 
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    public Student removeCourse(Integer studentId, Long courseId) 
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        student.getCourses().remove(course);
        return studentRepository.save(student);
    }

    private Student convertToEntity(StudentRequestDTO requestDTO) 
    {
        return modelMapper.map(requestDTO, Student.class);
    } 

    private StudentResponseDTO convertToResponseDTO(Student student) 
    {

    StudentResponseDTO dto = modelMapper.map(student, StudentResponseDTO.class);

    // Passport Mapping
    if (student.getPassport() != null) {

        PassportResponseDTO passportDTO = new PassportResponseDTO();

        passportDTO.setId(student.getPassport().getId());
        passportDTO.setPassportNumber(student.getPassport().getPassportNumber());

        dto.setPassport(passportDTO);
    }

    // Department Mapping
    if (student.getDepartment() != null) 
    {

        DepartmentResponseDTO departmentDTO = new DepartmentResponseDTO();

        departmentDTO.setId(student.getDepartment().getId());
        departmentDTO.setName(student.getDepartment().getName());

        dto.setDepartment(departmentDTO);
    }

    // Courses Mapping
    if (student.getCourses() != null) 
    {

        List<CourseResponseDTO> courseDTOs = student.getCourses().stream().map(course -> 
        {
            CourseResponseDTO courseDTO = new CourseResponseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setCourseName(course.getCourseName());
            courseDTO.setDuration(course.getDuration());
            return courseDTO;
        })
        .collect(Collectors.toList());
        dto.setCourses(courseDTOs);
    }return dto;
    }
}