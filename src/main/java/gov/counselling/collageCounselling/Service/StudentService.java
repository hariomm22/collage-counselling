package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    public List<StudentRequest> getAllStudent();
    public StudentResponse getStudent(long id);
    public StudentResponse getStudent(String userName);
    public StudentResponse createStudent(StudentRequest studentRequest);
    public StudentResponse updateStudent(StudentRequest studentRequest);
    public boolean deleteStudent(long id);
    public boolean deleteStudent(String userName);

}
