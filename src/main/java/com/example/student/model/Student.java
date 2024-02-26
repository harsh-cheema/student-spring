package com.example.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    public String id;

    public String name;

    public int age;

    public String adhaar;

    public String University;

    public Student(String id,String name,int age,String adhaar,String University){
        this.id=id;
        this.name=name;
        this.age=age;
        this.adhaar=adhaar;
        this.University=University;
        
    }
}
