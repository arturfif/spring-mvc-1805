package com.springapp.mvc.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturk on 19.05.2016.
 */

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String patronymic;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{3,50}$")
    private String login;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccessLevel level;

    @OneToMany(mappedBy = "person")
    private List<Document> documentList = new ArrayList<>();





}
