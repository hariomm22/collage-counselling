package gov.counselling.collagecounselling.service;


import gov.counselling.collagecounselling.dto.StudentRequest;
import gov.counselling.collagecounselling.dto.StudentResponse;
import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.exception.RecordAlreadyExistsException;
import gov.counselling.collagecounselling.exception.RecordNotFoundException;
import gov.counselling.collagecounselling.mapper.StudentMapper;
import gov.counselling.collagecounselling.reposistory.StudentReposistory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentReposistory studentReposistory;

    private final StudentMapper studentMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserAccountServiceImpl userAccountService;


    public StudentServiceImpl(StudentReposistory studentReposistory,
                              StudentMapper studentMapper, PasswordEncoder passwordEncoder,
                              UserAccountServiceImpl userAccountService){
        this.studentReposistory = studentReposistory;
        this.studentMapper =studentMapper;
        this.passwordEncoder = passwordEncoder;
        this.userAccountService =userAccountService;
    }

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
        if(studentReposistory.existsByUserName(userName)){
            Student student = studentReposistory.findByUserName(userName);
            return studentMapper.toResponse(student);
        }
        throw new RecordNotFoundException("Student not found with username "+userName);
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {

        String userName = studentRequest.getUserName();
        String password = studentRequest.getPassword();
        if(studentReposistory.existsByUserName(userName)){
            throw new RecordAlreadyExistsException("Student already exits with username "+userName);
        }
        Student student = studentMapper.toEnitiy(studentRequest);
        String encodedPassword = passwordEncoder.encode(password);
        student.setPassword(encodedPassword);
        student.setStatus(Student.StudentStatus.ACTIVE);
        studentReposistory.save(student);
        userAccountService.CreateUserAccount(student);
        return studentMapper.toResponse(student);
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
