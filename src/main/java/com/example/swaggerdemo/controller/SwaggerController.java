package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.entity.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class SwaggerController {

  ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

  @GetMapping("/{id}")
  public Contact getContact(@PathVariable("id") String id) {
    return contacts.get(id);
  }

  @GetMapping
  public List<Contact> getAllContact() {
    return new ArrayList<>(contacts.values());
  }

  @PostMapping
  public void addContact(@RequestBody Contact contact) {
    this.contacts.put(contact.getId(), contact);
  }
}
