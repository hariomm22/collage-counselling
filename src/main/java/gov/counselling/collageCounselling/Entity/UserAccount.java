package gov.counselling.collagecounselling.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_accounts")
@Getter
@Setter
@NoArgsConstructor
public class UserAccount {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String password;

    private List<Role> role;

    private UserType userType;

    private String profileId;

    private boolean enabled;

    public enum UserType {
        STUDENT,
        COLLEGE
    }

    public enum Role {
        STUDENT,
        COLLEGE,
        ADMIN
    }
}


