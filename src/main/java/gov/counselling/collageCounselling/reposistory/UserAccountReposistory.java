package gov.counselling.collagecounselling.reposistory;

import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.entity.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountReposistory extends MongoRepository<UserAccount, String> {
    public UserAccount findByUserName(String userName);
    public void deleteByUserName(String userName);
    public boolean existsByUserName(String userName);
}
