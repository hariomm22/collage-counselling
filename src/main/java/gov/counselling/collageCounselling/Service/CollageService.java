package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;

import java.util.List;

public interface CollageService {

    public List<CollageResponse> getAllCollage();
    public CollageResponse getCollage(String code);
    public CollageResponse createCollage(CollageRequest collageRequest);
    public CollageResponse updateCollage(String code,CollageRequest collageRequest);
    public boolean deleteCollage(String code);

}
