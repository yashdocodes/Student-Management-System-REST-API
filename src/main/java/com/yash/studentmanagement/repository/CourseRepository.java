package com.yash.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.studentmanagement.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>
{
}