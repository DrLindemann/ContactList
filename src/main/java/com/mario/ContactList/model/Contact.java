package com.mario.ContactList.model;


import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "surname")
    private String surname;

    @JoinColumn(name = "email", unique = true)
    private String email;

    //Constructors
    public Contact() {
    }

    public Contact(Long id, String name, String surmame, String email) {
        this.id = id;
        this.name = name;
        this.surname = surmame;
        this.email = email;
    }


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
