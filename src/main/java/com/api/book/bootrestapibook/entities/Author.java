package com.api.book.bootrestapibook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    
    
    public Author() {
    }

    
    public Author(int id, String name, String address, String language, Book book) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.language = language;
        this.book = book;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", address=" + address + ", language=" + language + "]";
    }

     
}
