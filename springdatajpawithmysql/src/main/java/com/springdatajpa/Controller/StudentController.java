package com.springdatajpa.Controller;

import com.springdatajpa.Entity.Student;
import com.springdatajpa.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/saveDetails")
    public Student saveDetails(@RequestBody Student student){
        return studentServices.saveDetails(student);
    }

    @GetMapping("/getList")
    public List<Student> getList(){
        return studentServices.getList();
    }

    @GetMapping("/byFirstName/{firstName}")
    public List<Student> printStudentByFirstName(@PathVariable String firstName){
        return studentServices.printStudentByFirstName(firstName);
    }

    @GetMapping("/byFirstNameContaining/{name}")
    public List<Student> printStudentByFirstNameContaining(@PathVariable String name){
        return studentServices.printStudentByFirstNameContaining(name);
    }

    @GetMapping("/printStudentBasedOnGuardianName/{guardianName}")
    public List<Student> printStudentBasedOnGuardianName(@PathVariable String guardianName){

        return studentServices.printStudentBasedOnGuardianName(guardianName);
    }

//    @GetMapping("/printGetStudentByEmailAddress/{emailId}")
//    public List<Student> printGetStudentByEmailAddress(@PathVariable String emailId) {
//        return studentServices.printGetStudentByEmailAddress(emailId);
//    }

    @GetMapping("/printGetStudentByEmailAddress/{emailId}")
    public Student printGetStudentByEmailAddress(@PathVariable String emailId) {
        return studentServices.printGetStudentByEmailAddresss(emailId);
    }

    @GetMapping("/printGetStudentFirstNameByEmailAddress/{emailId}")
    public String printGetStudentFirstNameByEmailAddress(@PathVariable String emailId) {
        return studentServices.printGetStudentFirstNameByEmailAddress(emailId);
    }

    @GetMapping("/printGetStudentByEmailAddressNative/{emailId}")
    public Student printGetStudentByEmailAddressNative(@PathVariable String emailId) {
        return studentServices.printGetStudentByEmailAddressNative(emailId);
    }

    @GetMapping("/printGetStudentByEmailAddressNativeNamedParam/{emailId}")
    public Student printGetStudentByEmailAddressNativeNamedParam(@PathVariable String emailId) {
        Student student = studentServices.printGetStudentByEmailAddressNativeNamedParam(emailId);
        return student;
    }

    @PutMapping("/updateStudentNameByEmailIdTest/{emailId}/{firstName}")
    public int updateStudentNameByEmailIdTest(@PathVariable("emailId") String emailId,
                                               @PathVariable("firstName") String firstName) {
        return studentServices.updateStudentNameByEmailIdTest(emailId, firstName);
    }
}
