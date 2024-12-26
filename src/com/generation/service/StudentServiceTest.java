package com.generation.service;

import com.generation.model.Student;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
        Map<String, Student> students;
        StudentService studentService;

        Student student1 = new Student("1", "John", "johndoe@gmail.com", new Date("15/10/2024"));

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        students = new HashMap<>();
        studentService = new StudentService();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Adding student to students passed")
    void subscribeStudent() {
        studentService.subscribeStudent(student1);
        Student retrievedStudent = students.get("1");
        assertEquals("John", studentService.findStudent("1").getName(), "Name of student 1 should be found in hashmap");
        assertEquals("johndoe@gmail.com", studentService.findStudent("1").getEmail(), "Email of student 1 should be found in hashmap");
        assertEquals(new Date("15/10/2024"), studentService.findStudent("1").getBirthDate(), "Birthdate of student 1 should be found in hashmap");

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Finding student method passed")
    void findStudent() {
        studentService.subscribeStudent(student1);
        assertEquals("John", studentService.findStudent("1").getName(), "Name of student 1 should be equal");
        assertEquals("johndoe@gmail.com", studentService.findStudent("1").getEmail(), "Email of student 1 should be equal");
        assertEquals(new Date("15/10/2024"), studentService.findStudent("1").getBirthDate(), "DOB of student 1 should be equal");

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Setting average of student passed")
    void gradeStudent() {
        studentService.subscribeStudent(student1);
        studentService.gradeStudent("1", 4.5);
        assertEquals(4.5, studentService.findStudent("1").getAverage(), "set average is reflected in hashmap");
    }

    @org.junit.jupiter.api.Test
    void isSubscribed() {
    }

    @org.junit.jupiter.api.Test
    void showSummary() {
    }

    @org.junit.jupiter.api.Test
    void enrollToCourse() {
    }
}