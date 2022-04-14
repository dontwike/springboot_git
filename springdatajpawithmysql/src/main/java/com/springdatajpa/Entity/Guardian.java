package com.springdatajpa.Entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardianEmail")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardianMobile")
        )
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
