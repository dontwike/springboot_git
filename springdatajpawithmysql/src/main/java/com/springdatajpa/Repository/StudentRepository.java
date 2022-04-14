package com.springdatajpa.Repository;

import com.springdatajpa.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByGuardianName(String guardianName);
//    List<Student> findByEmailId(String emailId);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "SELECT * FROM student_table s where s.email_id = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //Native Named Param
    @Query(
            value = "SELECT * FROM student_table s where s.email_id = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update student_table set first_name = ?1 where email_id = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
