package com.example.JPA.Repository;

import com.example.JPA.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<Teacher, Long> {
}
