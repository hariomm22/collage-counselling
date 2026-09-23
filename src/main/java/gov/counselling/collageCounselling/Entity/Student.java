package gov.counselling.collagecounselling.entity;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Student extends BaseEntity {
    @Id
    private String id;
    @NonNull
    private String  name;

    @NotNull
    @Indexed(unique = true)
    private String userName;
    private String password;
    private double score;
    @DBRef
    private List<Collage>  choice;
    private long rank;

    @DBRef
    private Collage allocateCollage;
    private StudentStatus status;

    public enum StudentStatus {
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }
}
