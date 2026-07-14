package com.yash.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.yash.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

    // ============================
    // Phase 10 - Derived Query Methods
    // ============================

    List<Student> findByName(String name);

    List<Student> findByNameContaining(String name);

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByAge(Integer age);

    List<Student> findByAgeGreaterThan(Integer age);

    List<Student> findByAgeLessThan(Integer age);


    // ============================
    // Phase 11 - JPQL & Native SQL
    // ============================

    // JPQL Query
    @Query("SELECT s FROM Student s")
    List<Student> getAllStudentsJPQL();

    // JPQL with WHERE
    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findStudentByName(@Param("name") String name);

    // JPQL with LIKE
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:keyword%")
    List<Student> searchStudent(@Param("keyword") String keyword);

    // JPQL with Multiple Conditions
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findStudentsAgeGreaterThan(@Param("age") int age);

    // Native SQL Query
    @Query(value = "SELECT * FROM student WHERE age < :age", nativeQuery = true)
    List<Student> findStudentsAgeLessThan(@Param("age") int age);

    // ============================
    // Positional Parameter
    // ============================

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    List<Student> findStudentByNamePosition(String name);


    // ============================
    // ORDER BY
    // ============================

    @Query("SELECT s FROM Student s ORDER BY s.age DESC")
    List<Student> getStudentsOrderByAgeDesc();


    // ============================
    // Aggregate Functions
    // ============================

    @Query("SELECT COUNT(s) FROM Student s")
    long countStudents();

    @Query("SELECT MAX(s.age) FROM Student s")
    Integer getMaximumAge();

    @Query("SELECT MIN(s.age) FROM Student s")
    Integer getMinimumAge();

    @Query("SELECT AVG(s.age) FROM Student s")
    Double getAverageAge();

    // ============================
    // UPDATE Query
    // ============================

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.age = :age WHERE s.id = :id")
    int updateStudentAge(@Param("id") Integer id,
                     @Param("age") Integer age);


    // ============================
    // DELETE Query
    // ============================

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.age < :age")
    int deleteStudentsAgeLessThan(@Param("age") Integer age);
}