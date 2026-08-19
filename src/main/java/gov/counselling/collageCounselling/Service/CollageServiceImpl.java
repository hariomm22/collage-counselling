package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.exception.RecordNotFoundException;
import gov.counselling.collagecounselling.exception.RecordAlreadyExistsException;
import gov.counselling.collagecounselling.mapper.CollageMapper;
import gov.counselling.collagecounselling.reposistory.CollageReposistory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollageServiceImpl implements CollageService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final CollageMapper collageMapper;
    private final CollageReposistory collageReposistory;
    public CollageServiceImpl(CollageMapper collageMapper, CollageReposistory collageReposistory) {
        this.collageMapper = collageMapper;
        this.collageReposistory = collageReposistory;
    }


    @Override
    public List<CollageResponse> getAllCollage() {
        List<Collage> collageList = collageReposistory.findAll();
        return collageMapper.toResponseList(collageList);
    }

    @Override
    public CollageResponse getCollage(String code) {
        if(collageReposistory.existsByCode(code)){
            Collage collage = collageReposistory.findByCode(code);
            return collageMapper.toResponse(collage);
        }
        throw new RecordNotFoundException("Collage Not Found with Code "+code);
    }

    @Override
    public CollageResponse createCollage(CollageRequest collageRequest) {
        String collageName = collageRequest.getName();
        if(collageReposistory.existsByName(collageName)){
            throw new RecordAlreadyExistsException("Collage already exists with name "+ collageName);
        }
        Collage collage = collageMapper.toEnitiy(collageRequest);
        collage.setStatus(Collage.CollageStatus.ACTIVE);
        collage.setCode("C"+collage.hashCode());
        String encodedPassword = passwordEncoder.encode(collageRequest.getPassword());
        collage.setPassword(encodedPassword);
        collage = collageReposistory.save(collage);
        return collageMapper.toResponse(collage);
    }

    @Override
    public CollageResponse updateCollage(String code,CollageRequest collageRequest) {

        Collage collage = collageReposistory.findByCode(code);
        if(collage != null){
            String newName = collageRequest.getName();
            if(newName!=null && !newName.isEmpty()){
                if(collageReposistory.existsByName(newName)){
                    throw new RecordAlreadyExistsException("Collage is already exists with name "+newName);
                }
                collage.setName(newName);
            }
            if(collageRequest.getSeat() != null){
                collage.setSeat(collageRequest.getSeat());
            }
            if(collageRequest.getStatus() != null){
                collage.setStatus(collageRequest.getStatus());
            }
            collageReposistory.save(collage);
            return collageMapper.toResponse(collage);
        }
        throw new RecordNotFoundException("Collage not found with code "+code);
    }

    @Override
    public boolean deleteCollage(String code) {

        if(collageReposistory.existsByCode(code)){
            collageReposistory.deleteByCode(code);
            return true;
        }
        throw new RecordAlreadyExistsException("Collage not found with code "+code);
    }
}
