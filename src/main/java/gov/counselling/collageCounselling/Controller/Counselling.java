package gov.counselling.collageCounselling.Controller;

 import gov.counselling.collageCounselling.Entity.Collage;
 import gov.counselling.collageCounselling.Entity.Student;
 import gov.counselling.collageCounselling.Service.StudentService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.*;

@RestController
@RequestMapping("counselling")
public class Counselling {

 List<Collage> collageList = new ArrayList<>();

 Map<Long,Student> studentList = new HashMap<>();

 @Autowired
 StudentService studentService;

 public Counselling(){
  collageList.add(new Collage(1,"IPS",4));
  collageList.add(new Collage(1,"SDB",6));
  collageList.add(new Collage(1,"GSITS",3));
 }

 @GetMapping
 public List<Student> getStudentList() {
  return new ArrayList<>(studentList.values());
 }

 @PostMapping
 public boolean createStudent(@RequestBody Student student){

      studentList.put(student.getId(),student);
      return true;
 }

 @GetMapping("/rank")
 public List<Student> maritList(){

  return studentService.generateRank(new ArrayList<>(studentList.values()));
 }

 @DeleteMapping("id/{id}")
 public  boolean deleteStudent(@PathVariable long id){
    studentList.remove(id);
    return true;
 }


}