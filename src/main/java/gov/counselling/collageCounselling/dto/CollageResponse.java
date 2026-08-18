package gov.counselling.collagecounselling.dto;

import gov.counselling.collagecounselling.entity.Collage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class CollageResponse {
    private String id;
    private String  name;
    private String code;
    private Long seat;
    private Collage.CollageStatus status;

}
