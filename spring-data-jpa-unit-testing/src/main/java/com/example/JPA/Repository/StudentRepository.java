package com.example.JPA.Repository;

import com.example.JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getByStudentEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getByFirstNameStudentEmailAddress(String emailId);

    //NativeQuery
    @Query(
            value = "SELECT * FROM student_table s where s.email_address = ?1",
            nativeQuery = true
    )
            Student getStudentByEmailAddressNative(String emailId);

    //NativeNamedQuery
    @Query(
            value = "SELECT * FROM student_table s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedQuery(@Param("emailId") String emailId);

//    @Modifying
//    @Transactional
//    @Query(
//            value = "update student_table set firstName=?1 where email_address = ?2",
//            nativeQuery = true
//    )
//    int updateStudentNameByEmailAddress(String firstName, String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update student_table set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
            int updateStudentNameByEmailId(String firstName, String emailId);
}
