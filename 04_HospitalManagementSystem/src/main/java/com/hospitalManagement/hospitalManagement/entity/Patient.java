package com.hospitalManagement.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
//        name = "patient-table", not changing here, but can be changed
        uniqueConstraints = {
                @UniqueConstraint(name = "uniqueEmail", columnNames = {"email"}),
                @UniqueConstraint(name = "uniqueNameAndDOB", columnNames = {"name", "birthDate"}),
        },
        indexes = {
                @Index(name = "indexedEmail", columnList = "email") //email is unique constraint
                // so it will already have an index, but we just add it here for understanding
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    private LocalDate dob;

    private String sex;
    private String email;

    @OneToOne //owning side
    @JoinColumn
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
