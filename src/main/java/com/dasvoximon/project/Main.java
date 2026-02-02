package com.dasvoximon.project;

public class Main {

    public static void main(String[] args) {

        SecretSantaMatcher matcher = new SecretSantaMatcher();
        matcher.studentsCounter(matcher.students());
        matcher.generatePairs(matcher.students());

    }
}
