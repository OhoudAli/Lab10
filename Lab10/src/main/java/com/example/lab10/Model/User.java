package com.example.lab10.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty
    @Size(min=4)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")
    private String name;

    @Email

    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null ")
    private String password;


    @Column(columnDefinition = "int not null")
    @NotNull
    @Positive
    @Min(21)
    private Integer age ;


    @Column(columnDefinition = "varchar(10)")
    @NotEmpty
    @Pattern(regexp = "job_seeker|employee")
    private String role;
}
