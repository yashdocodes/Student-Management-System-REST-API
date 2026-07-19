package com.yash.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.studentmanagement.entity.Course;
import com.yash.studentmanagement.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Long id, Course updatedCourse) {

        Course course = getCourseById(id);

        course.setCourseName(updatedCourse.getCourseName());
        course.setDuration(updatedCourse.getDuration());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {

        Course course = getCourseById(id);

        courseRepository.delete(course);
    }

}
