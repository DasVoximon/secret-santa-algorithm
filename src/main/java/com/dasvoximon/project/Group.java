package com.dasvoximon.project;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Student> members = new ArrayList<>();

    public void addMember(Student s) {
        members.add(s);
    }

    // Helper to check if this group contains a female (for the odd-number rule)
    public boolean hasFemale() {
        for (Student s : members) {
            if (s.gender.equals("F")) return true;
        }
        return false;
    }
}
