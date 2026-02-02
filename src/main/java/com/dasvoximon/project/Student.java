package com.dasvoximon.project;

public class Student {
    public String name;
    public String gender;
    public String contactInfo;

    public Student(String name, String gender, String contactInfo) {
        this.name = name;
        this.gender = gender.toUpperCase();
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ")";
    }
}