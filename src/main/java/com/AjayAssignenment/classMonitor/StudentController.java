package com.AjayAssignenment.classMonitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    public StudentController(){
       System.out.println("Beam of Controller");
    }

    @Autowired
    private StudentService service ;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudnet(@RequestBody Student std) {
        String str = service.add(std);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        service.addteacher(teacher);
        return new ResponseEntity<>("Teacher added", HttpStatus.OK);
    }

    @PutMapping("/teacher-student-Pair")
    public ResponseEntity<String> addpair(@RequestParam String student, @RequestParam String teacher) throws StudentInValidException{
        try {
            service.addstuteachpair(student, teacher);
            return new ResponseEntity<>("Pair added Sucessfully", HttpStatus.CREATED);
        } catch (StudentInValidException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
              return new ResponseEntity<>("Student is not present",HttpStatus.NOT_FOUND);
        } catch (TeacherInvalidException ex) {
            return new ResponseEntity<>("Teacher is not present", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity<Student> getStudentName(@PathVariable String name) {
        try {
            Student stu = service.getName(name);
            return new ResponseEntity<>(stu, HttpStatus.CREATED);

        } catch (StudentInValidException s) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-name-teacher/{name}")
    public ResponseEntity<Teacher> getTeacherName(@PathVariable String name){
    try {
        Teacher teach = service.getTeacherName(name);
        return new ResponseEntity<>(teach,HttpStatus.CREATED);
    }catch(TeacherInvalidException teach){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }

      @GetMapping("/get-List")
      public ResponseEntity<ArrayList<String>> getStudent(){
        ArrayList<String> list=service.getList();
     return new ResponseEntity<>(list,HttpStatus.OK);
    }

     @GetMapping("/c")
      public  ResponseEntity<ArrayList<String>> studentbyTeacher(@RequestParam String teacher){

      return new ResponseEntity<>(service.getStudents(teacher),HttpStatus.CREATED);
     }

}