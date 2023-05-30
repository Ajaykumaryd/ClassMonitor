package com.AjayAssignenment.classMonitor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private StudentService service = new StudentService();

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudnet(@RequestBody Student std){
     String str = service.add(std);
     return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity <String> addTeacher(@RequestBody Teacher teacher){
        service.addteacher(teacher);
        return new ResponseEntity<>( "Teacher added",HttpStatus.OK)   ;
    }

    @PutMapping("/teacher-student-Pair")
    public  ResponseEntity<String> addpair(@RequestParam String student,@RequestParam String teacher){
        try {
            service.addstuteachpair(student,teacher);
            return new ResponseEntity<>("Pair added Sucessfully",HttpStatus.CREATED);
        }
        catch (StudentInValidException e){
            return new ResponseEntity<>("Student not present",HttpStatus.NOT_FOUND);
        }
        catch (TeacherInvalidException ex){
            return new ResponseEntity<>("Teacher is not present",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public Student getStudentName(String name){
        service.getName(name);
    }

}
