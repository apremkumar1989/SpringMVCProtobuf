package com.premkumar.springmvcprotobuf.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premkumar.springmvcprotobuf.proto.ContactsProtos.AddressBook;
import com.premkumar.springmvcprotobuf.proto.ContactsProtos.Contact;
import com.premkumar.springmvcprotobuf.proto.ContactsProtos.Contact.ContactType;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@RequestMapping("")
	public AddressBook getContacts() {
		Contact contact = getDummyContact(null);
		Contact[] contactsArray = { contact, contact, contact };

		return AddressBook.newBuilder()
				.addAllContacts(Arrays.asList(contactsArray)).build();
	}

	@RequestMapping("/{id}")
	public Contact getContact(@PathVariable int id) {
		return getDummyContact(id);
	}

	private Contact getDummyContact(Integer id) {
		id = id == null ? 1 : id;
		return Contact.newBuilder().setId(id).setName("John")
				.setEmail("john@xyz.com").setMobile("9902XXXXXX")
				.setContactType(ContactType.WORK).build();
	}
}
