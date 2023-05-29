package com.AjayAssignenment.classMonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {

    HashMap<String,Student> studentmap=new HashMap<>();
    HashMap<String,Teacher> teachermap=new HashMap<>();

    HashMap<String,ArrayList<String>> pairMap=new HashMap<>();
    public void addStudent(Student std) {
    studentmap.put(std.getName(),std);
    }

    public void addTeacher(Teacher teacher) {
     teachermap.put(teacher.getName(),teacher);
    }

    public void addpairs(String student, String teacher) {
       ArrayList<String> students= pairMap.getOrDefault(teacher,new ArrayList<String>());
       students.add(student);
       pairMap.put(teacher,students);
    }
}
