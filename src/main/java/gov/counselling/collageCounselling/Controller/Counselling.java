package gov.counselling.collagecounselling.controller;

 import gov.counselling.collagecounselling.entity.Collage;
 import gov.counselling.collagecounselling.entity.Student;
 import gov.counselling.collagecounselling.service.StudentServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

@RestController
@RequestMapping("counselling")
public class  Counselling{

// List<Collage> collageList = new ArrayList<>();
//
// Map<Long,Student> studentList = new HashMap<>();
//
// @Autowired
// StudentServiceImpl studentServiceImpl;
//
// public Counselling(){
//  collageList.add(new Collage(101,"IPS",4));
//  collageList.add(new Collage(102,"SDB",6));
//  collageList.add(new Collage(103,"GSITS",3));
// }
//
// @GetMapping
// public List<Student> getStudentList() {
//  return new ArrayList<>(studentList.values());
// }
//
// @PostMapping
// public boolean createStudent(@RequestBody Student student){
//
//      studentList.put(student.getId(),student);
//      return true;
// }
//
// @GetMapping("/rank")
// public List<Student> maritList(){
//
//  return studentServiceImpl.generateRank(new ArrayList<>(studentList.values()));
// }
//
// @GetMapping("/allotement")
// public List<Student> allotementList(){
//  return studentServiceImpl.createAllotement(new ArrayList<>(studentList.values()),collageList);
// }
//
// @DeleteMapping("id/{id}")
// public  boolean deleteStudent(@PathVariable long id){
//    studentList.remove(id);
//    return true;
// }

}