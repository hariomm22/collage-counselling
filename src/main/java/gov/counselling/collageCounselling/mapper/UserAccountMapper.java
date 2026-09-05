package gov.counselling.collagecounselling.mapper;

import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.entity.UserAccount;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
public class UserAccountMapper {

    public UserAccount toEnitiy(Student student) {

        UserAccount userAccount = new UserAccount();

        userAccount.setUserName(student.getUserName());
        userAccount.setPassword(student.getPassword());
        userAccount.setProfileId(student.getId());
        userAccount.setEnabled(true);
        userAccount.setUserType(UserAccount.UserType.STUDENT);
        userAccount.setRole(List.of(UserAccount.Role.STUDENT));

        return userAccount;
    }


    public UserAccount toEnitiy(Collage collage) {

        UserAccount userAccount = new UserAccount();

        userAccount.setUserName(collage.getCode());
        userAccount.setPassword(collage.getPassword());
        userAccount.setProfileId(collage.getId());
        userAccount.setEnabled(true);
        userAccount.setUserType(UserAccount.UserType.COLLEGE);
        userAccount.setRole(List.of(UserAccount.Role.COLLEGE));

        return userAccount;
    }
}
