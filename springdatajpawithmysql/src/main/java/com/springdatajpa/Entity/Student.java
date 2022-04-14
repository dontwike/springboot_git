package com.springdatajpa.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "student_table",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "emailId"
        )
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stdId;
    private String firstName;
    private String lastName;
    @Column(
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}
