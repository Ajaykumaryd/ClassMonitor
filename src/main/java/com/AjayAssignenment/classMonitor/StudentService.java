package com.AjayAssignenment.classMonitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {


    public StudentService(){
        System.out.println("Beam of studentService");
    };
    @Autowired
    private StudentRepository repository;
    public String add(Student std) {
        repository.addStudent(std);
        return "Student added";
    }

    public void addteacher(Teacher teacher) {
        repository.addTeacher(teacher);
    }

    public void addstuteachpair(String student, String teacher) throws StudentInValidException,TeacherInvalidException {
        Optional<Student> studentOptional=repository.getStudent(student);
        Optional<Teacher> teacherOptional=repository.getTeacher(teacher);
        if(studentOptional.isEmpty()){
            throw new StudentInValidException(student);
        }
        if(teacherOptional.isEmpty()){
            throw new TeacherInvalidException();
        }
        repository.addpairs(student,teacher);
    }


    public Student getName(String name) throws StudentInValidException {
        Optional<Student> stuOptional=repository.getStudent(name);
        if(stuOptional.isEmpty()){
            throw new StudentInValidException(name);
        }else{
              return stuOptional.get();
        }
    }

    public Teacher getTeacherName(String name) throws TeacherInvalidException {
    Optional<Teacher> optionalTeacher=repository.getTeacher(name);
    if(optionalTeacher.isEmpty()){
        throw new TeacherInvalidException();
    }
    return optionalTeacher.get();
    }
    public ArrayList<String> getList() {
        ArrayList<String> ans=repository.getListStudents();
        return ans;
    }

    public ArrayList<String> getStudents(String teacher) {

    return repository.getStudentsName(teacher);

    }
}
