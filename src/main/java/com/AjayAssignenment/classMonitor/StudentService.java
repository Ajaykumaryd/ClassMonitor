package com.AjayAssignenment.classMonitor;

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
        repository.addpairs(student,teacher);
    }
}
