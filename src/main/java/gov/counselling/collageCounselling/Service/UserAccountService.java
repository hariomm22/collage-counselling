package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.dto.CurrentUserAccountReponse;
import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.entity.UserAccount;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserAccountService {

    public UserAccount getUserAccount(String userName);
    public void CreateUserAccount(Collage collage);
    public void CreateUserAccount(Student student);
//    public CollageResponse updateCollage(String code,CollageRequest collageRequest);
    public boolean deleteCollage(String userName);

    public CurrentUserAccountReponse getCurrentAccountReponse(Authentication authentication);

}
