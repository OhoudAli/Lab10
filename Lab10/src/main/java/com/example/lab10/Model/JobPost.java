package com.example.lab10.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty
    @Size(min = 4)
    private String title;

    @Column(columnDefinition = "varchar(30) not null")
    @NotEmpty
    private String description;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty
    private String location;

    @Column(columnDefinition = "double not null")
    @NotNull
    @Positive
    private Double salary;


    private LocalDate postingDat;
}
