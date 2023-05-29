package com.AjayAssignenment.classMonitor;

public class Teacher {

    private String name;
    private int numOfStudents;
    private int ages;

    public Teacher(){

    }

    public Teacher(String name, int numOfStudents, int ages) {
        this.name = name;
        this.numOfStudents = numOfStudents;
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }
}
