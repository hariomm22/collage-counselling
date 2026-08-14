package gov.counselling.collageCounselling.Repo;

import gov.counselling.collageCounselling.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student,Long> {
}
