package gov.counselling.collagecounselling.dto;

import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class StudentResponse {
    private String id;
    private String  name;
    private String userName;
    private double score;
    private Collage allocateCollage;
    private List<Collage> choice;
    private Student.StudentStatus status;

}
