package gov.counselling.collagecounselling.dto;

import gov.counselling.collagecounselling.entity.Collage;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
public class StudentResponse {
    private String id;
    private String  name;
    private String userName;
    private String password;
    private double score;
    private Collage allocateCollage;
    private List<Collage> choice;
    private boolean Status;

}
