package com.example.JPA.Repository;

import com.example.JPA.entity.Course;
import com.example.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class teacherRepositoryTest {

    @Autowired
    private teacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository ;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(4)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Qutub")
                        .lastName("Khan")
                        //.course(List.of(courseDBA,courseJAVA))
                        .build();

        teacherRepository.save(teacher);
        System.out.println(teacher);
    }


}