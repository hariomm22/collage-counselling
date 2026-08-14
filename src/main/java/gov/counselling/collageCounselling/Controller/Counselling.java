package gov.counselling.collageCounselling.Controller;

 import gov.counselling.collageCounselling.Entity.Collage;
 import gov.counselling.collageCounselling.Entity.Student;
 import gov.counselling.collageCounselling.Service.StudentService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

@RestController
@RequestMapping("counselling")
public class  Counselling{

 List<Collage> collageList = new ArrayList<>();

 Map<Long,Student> studentList = new HashMap<>();

 @Autowired
 StudentService studentService;

 public Counselling(){
  collageList.add(new Collage(101,"IPS",4));
  collageList.add(new Collage(102,"SDB",6));
  collageList.add(new Collage(103,"GSITS",3));
 }

 @GetMapping
 public List<Student> getStudentList() {
  return studentService.getAllStudent();
 }

 @PostMapping
 public Student createStudent(@RequestBody Student student){
      return studentService.createStudent(student);

 }

 @GetMapping("/rank")
 public List<Student> maritList(){

  return studentService.generateRank(new ArrayList<>(studentList.values()));
 }

 @GetMapping("/allotement")
 public List<Student> allotementList(){
  return studentService.createAllotement(new ArrayList<>(studentList.values()),collageList);
 }

 @DeleteMapping("id/{id}")
 public  boolean deleteStudent(@PathVariable long id){
    return studentService.deleteStudent(id);
 }

}