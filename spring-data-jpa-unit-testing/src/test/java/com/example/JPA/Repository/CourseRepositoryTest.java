package com.example.JPA.Repository;

import com.example.JPA.Repository.CourseRepository;
import com.example.JPA.entity.Course;
import com.example.JPA.entity.Student;
import com.example.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPagewithThreeRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(firstPagewithThreeRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllBySorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );

        Pageable sortByCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("title").and(Sort.by("credit").descending())
        );

        List<Course> courses =
                courseRepository.findAll(sortByCreditDesc)
                        .getContent();

        System.out.println(courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D",firstTenRecords);
        System.out.println(courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}