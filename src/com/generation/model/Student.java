package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    // new HashMap to save course code and assigned GPA
    private final Map<String, Double> gradedCourses = new HashMap<>();
    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        average = 0.0;
    }

    public Student( String id, String name, String email, Date birthDate, double average )
    {
        super( id, name, email, birthDate );
        this.average = average;
    }

    public void enrollToCourse( Course course )
    {
        if(!courses.contains(course) || !approvedCourses.containsValue(course)) {
            courses.add(course);
            approvedCourses.put(course.getCode(), course);
            System.out.println( "Student with ID: " + super.getId() + " enrolled successfully to " + course.getCode() );
        }
        else
            System.out.println("Student is already registered to course.");

    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        return approvedCourses.containsKey(courseCode);
    }

    public Course findStudentCourseIndex(String code) {
        if ( approvedCourses.containsKey( code ) )
        {
            return approvedCourses.get( code );
        }
        return null;
    }

    // putting new code and gpa entries into the gradedCourses HashMap
    public void gradeStudentCourse (String code, double gpa) {
        gradedCourses.put(code, gpa);

    }

    // calculating the average by using a for loop on the gradedCourses HashMap
    public void calculateStudentAverage() {
        double totalGpa = 0;
        for(Map.Entry<String, Double> entry: gradedCourses.entrySet()) {
            totalGpa += entry.getValue();
        }

        setAverage(totalGpa / gradedCourses.size());
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses(Course course)
    {

        //TODO implement this method
        return null;

    }

    public boolean isAttendingCourse( String courseCode )
    {

        for (Course course : courses) {

            if(course.getCode().contains(courseCode))
                return true;

        }

        return (approvedCourses.containsKey(courseCode));
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Map<String, Double> getGradedCourses() {
        return gradedCourses;
    }

    public void printGradedCourses() {
        gradedCourses.forEach((courseCode, gpa) ->{
            System.out.println(courseCode + " = " + gpa);
        });
    }

    public void printApprovedCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        if (!courses.isEmpty())
            return courses;

        return null;
    }


    @Override
    public String toString() {
        return String.format(
                "{id: %s, name: %s, email: %s, DOB: %s, average GPA: %.2f}",
                super.getId(),
                super.getName(),
                super.getEmail(),
                super.getBirthDate(),
                this.average
        );
    }

    /*@Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }*/
}
