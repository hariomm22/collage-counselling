package gov.counselling.collagecounselling.dto;

import gov.counselling.collagecounselling.entity.Collage;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class StudentRequest {
    private String  name;
    private String userName;
    private String password;
    private double score;
    private List<Collage> choice;
}

