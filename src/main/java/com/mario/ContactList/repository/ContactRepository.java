package com.mario.ContactList.repository;

import com.mario.ContactList.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    //Buscara al contacto por su nombre
    List<Contact> findContactByName(String name);

    //Buscara al contacto por su apellido
    List<Contact> findContactBySurname(String surname);

    //Buscara al contacto por email
    Contact findContactByEmail(String email);




}
