package com.AjayAssignenment.classMonitor;

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

    public void addstuteachpair(String student, String teacher) {
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
}
