package com.springdatajpa.Services;

import com.springdatajpa.Entity.Student;
import com.springdatajpa.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveDetails(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getList() {
        return studentRepository.findAll();
    }

    public List<Student> printStudentByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> printStudentByFirstNameContaining(String name){
        return studentRepository.findByFirstNameContaining(name);
    }

    public List<Student> printStudentBasedOnGuardianName(String guardianName) {
        List<Student> students = studentRepository.findByGuardianName(guardianName);
        return students;
    }

//    public List<Student> printGetStudentByEmailAddress(String emailId) {
//        List<Student> student = studentRepository.findByEmailId(emailId);
//        return student;
//    }

    public Student printGetStudentByEmailAddresss(String emailId) {
        Student student = studentRepository.getStudentByEmailAddress(emailId);
        return student;
    }

    public String printGetStudentFirstNameByEmailAddress(String emailId) {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress(emailId);
        return firstName;
    }

    public Student printGetStudentByEmailAddressNative(String emailId){
        Student student = studentRepository.getStudentByEmailAddressNative(emailId);
        return student;
    }

    public Student printGetStudentByEmailAddressNativeNamedParam(String emailId) {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(emailId);
        return student;
    }

    public int updateStudentNameByEmailIdTest(String emailId, String firstName) {
        return studentRepository.updateStudentNameByEmailId(firstName, emailId);
    }

}
