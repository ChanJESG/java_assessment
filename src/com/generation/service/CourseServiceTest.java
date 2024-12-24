package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    CourseService courseService = new CourseService();

    Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
            "Introductory module for the generation technical programs" );

    Map<String, Course> courses = new HashMap<>();

    Map<String, List<Student>> enrolledStudents = new HashMap<>();

    Course course1 = new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module);
    Student student1 = new Student("1", "John", "johndoe@gmail.com", new Date("15/10/2024"));

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Registering course passed")
    void registerCourse() {
        courseService.registerCourse(course1);
        assertEquals("INTRO-CS-1", courseService.getCourse("INTRO-CS-1").getCode(), "added course should have same code as course1");
        assertEquals("Introduction to Computer Science", courseService.getCourse("INTRO-CS-1").getName(), "added course should have same name as course1");
        assertEquals(9, courseService.getCourse("INTRO-CS-1").getCredits(),"added course should have same credits as course1");
    }

    @Test
    @DisplayName("Getting course passed")
    void getCourse() {
        courseService.registerCourse(course1);
        assertEquals("INTRO-CS-1", courseService.getCourse("INTRO-CS-1").getCode(), "added course should have same code as course1");
        assertEquals("Introduction to Computer Science", courseService.getCourse("INTRO-CS-1").getName(), "added course should have same name as course1");
        assertEquals(9, courseService.getCourse("INTRO-CS-1").getCredits(),"added course should have same credits as course1");
    }

    @Test
    void enrollStudent() {

    }

    @Test
    void showEnrolledStudents() {
    }

    @Test
    void showSummary() {
    }
}