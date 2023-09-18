package com.mario.ContactList.service;

import com.mario.ContactList.Exception.EmailAlreadyExistException;
import com.mario.ContactList.model.Contact;
import com.mario.ContactList.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    //Metodos aniadidos de busqueda

    public List<Contact> findContactByName(String name){
        return contactRepository.findContactByName(name);
    }

    public List<Contact> findContactBySurname(String surname){
        return contactRepository.findContactBySurname(surname);
    }

    public Contact findContactByEmail(String email){
        return contactRepository.findContactByEmail(email);
    }

    //CRUD basico

    public List<Contact> findAllContacts(){
        return contactRepository.findAll();
    }

    public Contact findContactById(Long id){
        return contactRepository.findById(id).orElse(null);
    }
    //Este metodo comprobara que no haya otro contacto con el mismo correo y si lo hay lanzar una excepcion y no creara el nuevo contacto
    public Contact addContact(Contact contact){
        Contact existingContact = contactRepository.findContactByEmail(contact.getEmail());
        if (existingContact != null){
            throw new EmailAlreadyExistException("Ya hay un contacto con ese E-Mail");
        }
        return contactRepository.save(contact);

    }

    public Contact updateContact (Long id, Contact updatedContact){
        Contact contact = contactRepository.findById(id).orElse(null);
        //primero comprobamos que hay un contacto con el id pasado por parametro
        if (contact != null){
            //estas comprobaciones hacen que si se recibe uno de los atributos nulos, queden guardados los anteriores
            if (updatedContact.getName() != null){
                contact.setName(updatedContact.getName());
            }
            if (updatedContact.getSurname()!= null){
                contact.setSurname(updatedContact.getSurname());
            }
            if (updatedContact.getEmail() != null){
                contact.setEmail(updatedContact.getEmail());
            }
            return contactRepository.save(contact);
        }else{
            return null;
        }
    }

    public void deleteContactById(Long id){
        contactRepository.deleteById(id);
    }


}
