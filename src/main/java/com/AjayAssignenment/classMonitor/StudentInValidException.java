package com.AjayAssignenment.classMonitor;

public class StudentInValidException extends RuntimeException{

    public StudentInValidException(String student){

        super("Student is not present "+student);
    }


}
