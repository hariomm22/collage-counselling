package gov.counselling.collagecounselling.dto;


import gov.counselling.collagecounselling.entity.UserAccount;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class CurrentUserAccountReponse {

    private String id;

    private String userName;

    private List<UserAccount.Role> role;

    private UserAccount.UserType userType;

    private Object profile;
}
