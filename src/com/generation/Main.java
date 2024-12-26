package com.generation;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main
{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );

        // ! student used for testing, remove after finished
        Student student = new Student("1", "John", "johndoe@gmail.com", new Date(15/10/2024));
        studentService.subscribeStudent(student);
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    gradeStudentCourse(studentService, scanner);
                    break;
                case 5:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 6:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 7:
                    showCoursesSummary( courseService, scanner );
                    break;

            }
        }
        while ( option != 8 );
    }

    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        courseService.enrollStudent( courseId, student );
        studentService.enrollToCourse( studentId, course );
        /*System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );*/

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student != null) {
            System.out.println("Enter student GPA: ");
            double average = scanner.nextDouble();
            studentService.gradeStudent(studentId, average);
            System.out.println("Grade updated: ");
            System.out.println(student);

        } else {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }

    }

    // using the gradedCourses HashMap (in Student class) to save courseCode and gpa
    private static void gradeStudentCourse (StudentService studentService, Scanner scanner) {
        System.out.println("Enter student ID");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student != null) {
            System.out.println("Courses to grade: ");
            student.printApprovedCourses();
            System.out.println("Select course to grade: ");
            String courseCode = scanner.next();
            Course gradedCourse = student.findStudentCourseIndex(courseCode);
            if (gradedCourse != null) {
                System.out.println(gradedCourse);
                System.out.println("Enter GPA: ");
                double gpa = scanner.nextDouble();
                student.gradeStudentCourse(courseCode, gpa);
                System.out.println("GPA updated.");
                student.calculateStudentAverage();
                student.printGradedCourses();
                System.out.println("The new GPA average is " + student.getAverage() + ".");
            } else
                System.out.println("Please enter a valid course code.");

        } else
            System.out.println("Student with Id = " + studentId + " not found" );
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner )
        throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }
}
