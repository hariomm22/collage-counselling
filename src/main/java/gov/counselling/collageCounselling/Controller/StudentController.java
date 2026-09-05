package gov.counselling.collagecounselling.controller;

import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;
import gov.counselling.collagecounselling.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService){
        this.studentService =studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentResponse> createStudent(
            @RequestBody StudentRequest studentRequest){

        StudentResponse studentResponse = studentService.createStudent(studentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
     }

//    @PostMapping
//    public ResponseEntity<CollageResponse> createStudent(@RequestBody CollageRequest collageRequest){
//        CollageResponse collageResponse = collageService.createCollage(collageRequest);
//        return ResponseEntity.status(HttpStatus.CREATED).body(collageResponse);
//    }

    @GetMapping("/{userName}")
    public ResponseEntity<StudentResponse> getStudent
            (@PathVariable String userName){

        StudentResponse studentResponse = studentService.getStudent(userName);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

}
