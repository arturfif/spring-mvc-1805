package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty studentSpecialty;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private User userOfStudent;

}
