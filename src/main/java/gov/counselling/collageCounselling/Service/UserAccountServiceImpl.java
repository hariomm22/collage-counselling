package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.entity.UserAccount;
import gov.counselling.collagecounselling.mapper.UserAccountMapper;
import gov.counselling.collagecounselling.reposistory.UserAccountReposistory;
import org.springframework.stereotype.Service;


@Service
public class UserAccountServiceImpl implements UserAccountService{

    private final UserAccountReposistory userAccountReposistory;

    private final UserAccountMapper userAccountMapper;

    public UserAccountServiceImpl(
            UserAccountReposistory userAccountReposistory,
            UserAccountMapper userAccountMapper){

        this.userAccountReposistory=userAccountReposistory;
        this.userAccountMapper = userAccountMapper;

    }

    @Override
    public UserAccount getUserAccount(String userName) {
        return null;
    }

    @Override
    public void CreateUserAccount(Collage collage) {
        UserAccount userAccount = userAccountMapper.toEnitiy(collage);
        userAccountReposistory.save(userAccount);
    }

    @Override
    public void CreateUserAccount(Student student) {
        UserAccount userAccount = userAccountMapper.toEnitiy(student);
        userAccountReposistory.save(userAccount);

    }

    @Override
    public boolean deleteCollage(String userName) {
        return false;
    }
}
