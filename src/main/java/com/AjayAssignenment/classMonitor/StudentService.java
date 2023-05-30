package com.AjayAssignenment.classMonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class StudentService {

    private StudentRepository repository=new StudentRepository();
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



}
