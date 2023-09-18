package com.mario.ContactList.controller;


import com.mario.ContactList.model.Contact;
import com.mario.ContactList.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    //Metodos de busqueda adicionales

    @GetMapping("/searchname")
    public List<Contact> findContactByName(@RequestParam String name){
        return contactService.findContactByName(name);
    }
    @GetMapping("/searchsurname")
    public List<Contact> findContactBySurname(@RequestParam String surname){
        return contactService.findContactBySurname(surname);
    }
    @GetMapping("/searchemail")
    public Contact findByEmail(@RequestParam String email){
        return contactService.findContactByEmail(email);
    }

    //CRUD

    @GetMapping("/")
    public List<Contact> findAllContacts(){
        return contactService.findAllContacts();
    }

    @GetMapping("/{id}")
    public Contact findContactById(@PathVariable Long id){
        return contactService.findContactById(id);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact){
        return contactService.updateContact(id, updatedContact);
    }

    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable Long id){
        contactService.deleteContactById(id);
    }

}
