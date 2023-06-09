package com.AjayAssignenment.classMonitor;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class StudentRepository {

    public StudentRepository(){
        System.out.println("Beam of  Repo");
    }
    HashMap<String,Student> studentmap=new HashMap<>();
    HashMap<String,Teacher> teachermap=new HashMap<>();

    HashMap<String,ArrayList<String>> pairMap=new HashMap<>();
    public void addStudent(Student std) {
    studentmap.put(std.getName(),std);
    }

    public void addTeacher(Teacher teacher) {
     teachermap.put(teacher.getName(),teacher);
    }

    public void addpairs(String student, String teacher){
       ArrayList<String> students= pairMap.getOrDefault(teacher,new ArrayList<String>());
       students.add(student);
       pairMap.put(teacher,students);
    }

    public Optional<Student> getStudent(String student){
        if(studentmap.containsKey(student)){
            return Optional.of(studentmap.get(student));
        }else{
            return Optional.empty();
        }
    }
    public Optional<Teacher> getTeacher(String teacher){
      if(teachermap.containsKey(teacher)){
         return Optional.of(teachermap.get(teacher));
      }else{
          return Optional.empty();
      }
    }


    public ArrayList<String> getListStudents() {
//    ArrayList<String> ans= new ArrayList<>(studentmap.keySet());
//    return ans;
        return new ArrayList<>(studentmap.keySet());
    }

    public ArrayList<String> getStudentsName(String teacher){
      return new ArrayList<>(pairMap.get(teacher));
    }
    
    public void delete(String name){
    studentmap.remove(name);

    }
}
