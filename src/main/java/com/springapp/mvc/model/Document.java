package com.springapp.mvc.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arturk on 19.05.2016.
 */

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "library_key")
    private String libraryKey;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "publishing_year")
    private Year publishingYear;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Column(name = "upload_date")
    private Date uploadDate;

    @NotNull
    @Column(name = "object_key")
    private String objectKey;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private User userOfDocument;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty documentSpecialty;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "document_author", joinColumns = {
            @JoinColumn(name = "document_id", nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id",
                            nullable = false)})
    private Set<Author> authorSet = new HashSet<>();

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibraryKey() {
        return libraryKey;
    }

    public void setLibraryKey(String libraryKey) {
        this.libraryKey = libraryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Year getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Year publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getPerson() {
        return userOfDocument;
    }

    public void setPerson(User user) {
        this.userOfDocument = user;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public String getObjectKey() {
        return objectKey;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public Specialty getDocumentSpecialty() {
        return documentSpecialty;
    }

    public void setDocumentSpecialty(Specialty documentSpecialty) {
        this.documentSpecialty = documentSpecialty;
    }
}
