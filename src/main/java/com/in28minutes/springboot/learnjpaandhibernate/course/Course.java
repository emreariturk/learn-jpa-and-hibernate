package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Course") // eğer db tablo adı ile class adı aynı olmazsa, name ile tablo eşleştirmesi yapılabilir
public class Course {
    @Id
    private Long id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "author",length = 50)
    private String author;


    public Course() {
    }

    public Course(Long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
