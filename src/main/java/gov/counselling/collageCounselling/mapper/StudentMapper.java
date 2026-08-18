package gov.counselling.collagecounselling.mapper;

import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;
import gov.counselling.collagecounselling.entity.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentMapper {
    public Student toEnitiy(StudentRequest request){
        Student student = new Student();
        student.setName(request.getName());
        student.setUserName(request.getUserName());
        student.setPassword(request.getPassword());
        student.setChoice(request.getChoice());
        return student;
    }

    public StudentResponse toResponse(Student student){
        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setName(student.getName());
        studentResponse.setUserName(student.getUserName());
        studentResponse.setScore(student.getScore());
        studentResponse.setAllocateCollage(student.getAllocateCollage());
        studentResponse.setChoice(student.getChoice());
        studentResponse.setStatus(student.isStatus());

        return studentResponse;
    }
}
