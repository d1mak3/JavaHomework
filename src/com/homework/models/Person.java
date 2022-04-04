package com.homework.models;

public class Person {
    public String Name;
    public int Year;

    public Person(String name, int year) {
        Name = name;
        Year = year;
    }

    @Override
    public String toString() {
        return "Name: " + Name + "\nYear: " + Year;
    }
}
