package gov.counselling.collagecounselling.reposistory;

import gov.counselling.collagecounselling.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposistory extends MongoRepository<Student, System> {
}
