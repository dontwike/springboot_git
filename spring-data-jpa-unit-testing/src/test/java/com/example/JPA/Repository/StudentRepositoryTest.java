package com.example.JPA.Repository;

import com.example.JPA.entity.Guardian;
import com.example.JPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("pranjal@gmail.com")
                .firstName("Pranjal")
                .lastName("Goyal")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAll(){

        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardianDetails(){

        Guardian guardian = Guardian.builder()
                .name("asd")
                .email("asd@gmail.com")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .emailId("sdf@gmail.com")
                .firstName("sdf")
                .lastName("sss")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Pranjal");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("jal");
        System.out.println(students);
    }

    @Test
    public void printGuardinByNameContaining(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println(students);
    }

    @Test
    public void getByStudentEmailAddress(){
        Student student = studentRepository.getByStudentEmailAddress("pranjal1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getByFirstNameStudentEmailAddress(){
        String student = studentRepository.getByFirstNameStudentEmailAddress("pranjal1@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("pranjal1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedQuery(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedQuery("pranjal1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "sdf",
                "sdf@gmail.com"
        );
    }
}