package gov.counselling.collagecounselling.reposistory;

import gov.counselling.collagecounselling.entity.Collage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollageReposistory extends MongoRepository<Collage, String> {
    public boolean existsByCode(String code);
    public Collage findByCode(String code);
    public void deleteByCode(String code);
    public boolean existsByName(String name);
}
