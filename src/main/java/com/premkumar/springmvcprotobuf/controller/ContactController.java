package com.premkumar.springmvcprotobuf.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premkumar.springmvcprotobuf.model.Contact;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@RequestMapping("")
	public Contact[] getContacts(){
		Contact contact = getDummyContact(null);
		Contact[] contacts = {contact,contact,contact};
		return contacts;
	}
	
	@RequestMapping("/{id}")
	public Contact getContact(@PathVariable int id){
		return getDummyContact(id);
	}
	
	private Contact getDummyContact(Integer id){
		id = id==null ? 1 : id;
		return new Contact(id, "John", "9902XXXXXX", "XXXXYYY@gmail.com");
	}
}
