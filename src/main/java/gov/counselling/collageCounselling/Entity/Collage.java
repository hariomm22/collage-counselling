package gov.counselling.collagecounselling.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Collage {

    @Id
    private String id;
    @Indexed(unique = true)
    private String  name;
    @Indexed(unique = true)
    private String code;
    private Long seat;
    private CollageStatus status;

    public enum CollageStatus {
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }
}
