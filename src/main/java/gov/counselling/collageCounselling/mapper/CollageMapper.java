package gov.counselling.collagecounselling.mapper;

import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;
import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CollageMapper {
    public Collage toEnitiy(CollageRequest request){
        Collage collage = new Collage();

        collage.setName(request.getName());
        collage.setSeat(request.getSeat());
        return collage;
    }

    public CollageResponse toResponse(Collage collage){
        CollageResponse collageResponse = new CollageResponse();

        collageResponse.setId(collage.getId());
        collageResponse.setName(collage.getName());
        collageResponse.setCode(collage.getCode());
        collageResponse.setSeat(collage.getSeat());
        collageResponse.setStatus(collage.getStatus());

        return collageResponse;
    }

    public List<CollageResponse> toResponseList(List<Collage> collages) {
        return collages.stream()
                .map(this::toResponse)
                .toList();

    }
}
