package gov.counselling.collagecounselling.entity;



import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Indexed(unique = true)
    private String  name;

    @NotNull
    @Indexed(unique = true)
    private String code;

    private Long seat;

    @NotNull
    private String password;

    private CollageStatus status;

    public enum CollageStatus {
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }
}
