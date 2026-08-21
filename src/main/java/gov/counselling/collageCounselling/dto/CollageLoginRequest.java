package gov.counselling.collagecounselling.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CollageLoginRequest {

    private String code;
    private String password;
}
