package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public void gradeStudent (String studentId, double average) {
        Student student = students.get(studentId);
        student.setAverage(average);
    }


    public boolean isSubscribed( String studentId )
    {
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        System.out.println("Students' Courses");
        for (String key: students.keySet()) {
            Student student = students.get(key);
            System.out.println("Student: " + student.toString());

            System.out.println("The student's course list: ");
            List<Course> courseList = student.getApprovedCourses();
            if(courseList != null) {
                for (Course c : courseList) {
                    System.out.println(c.toString());
                }
            } else
                System.out.println("No courses");
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }

}
