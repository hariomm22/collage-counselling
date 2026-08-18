package gov.counselling.collagecounselling.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Student {
    @Id
    private String id;
    @NonNull
    private String  name;
    private String userName;
    private String password;
    private double score;
    @DBRef
    private List<Collage>  choice;
    private long rank;
    private Collage allocateCollage;
    private boolean status;
}
