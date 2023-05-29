package com.AjayAssignenment.classMonitor;

public class Student {

    private String name;
    private int age;
    private double averageScores;

    public Student(String name, int age, double averageScores) {
        this.name = name;
        this.age = age;
        this.averageScores = averageScores;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScores() {
        return averageScores;
    }

    public void setAverageScores(double averageScores) {
        this.averageScores = averageScores;
    }
}
