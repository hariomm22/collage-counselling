package gov.counselling.collagecounselling.dto;

import gov.counselling.collagecounselling.entity.Collage;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class CollageRequest {
        private String  name;
        private Long seat;
        private String password;
        private Collage.CollageStatus status;
}

