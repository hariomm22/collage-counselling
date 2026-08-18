package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentRequest> getAllStudent() {
        return List.of();
    }

    @Override
    public StudentResponse getStudent(long id) {
        return null;
    }

    @Override
    public StudentResponse getStudent(String userName) {
        return null;
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public boolean deleteStudent(long id) {
        return false;
    }

    @Override
    public boolean deleteStudent(String userName) {
        return false;
    }
}
