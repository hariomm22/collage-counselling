package gov.counselling.collagecounselling.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAccountLoginRequest {

    private String userName;
    private String password;
}
