package gov.counselling.collagecounselling.service;

import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.dto.CurrentUserAccountReponse;
import gov.counselling.collagecounselling.dto.StudentResponse;
import gov.counselling.collagecounselling.entity.Collage;
import gov.counselling.collagecounselling.entity.Student;
import gov.counselling.collagecounselling.entity.UserAccount;
import gov.counselling.collagecounselling.exception.RecordNotFoundException;
import gov.counselling.collagecounselling.mapper.CollageMapper;
import gov.counselling.collagecounselling.mapper.StudentMapper;
import gov.counselling.collagecounselling.mapper.UserAccountMapper;
import gov.counselling.collagecounselling.reposistory.CollageReposistory;
import gov.counselling.collagecounselling.reposistory.StudentReposistory;
import gov.counselling.collagecounselling.reposistory.UserAccountReposistory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class UserAccountServiceImpl implements UserAccountService{

    private final UserAccountReposistory userAccountReposistory;

    private final UserAccountMapper userAccountMapper;

    private final CollageReposistory collageReposistory;

    private final StudentMapper studentMapper;

    private final CollageMapper collageMapper;

   // private final CollageService collageService;

    //private final  StudentService studentService;




    private final StudentReposistory studentReposistory;

    public UserAccountServiceImpl(
            UserAccountReposistory userAccountReposistory,
            UserAccountMapper userAccountMapper,
            CollageReposistory collageReposistory,
            StudentReposistory studentReposistory,
            StudentMapper studentMapper,
            CollageMapper collageMapper
//            ,CollageService collageService,
//            StudentService studentService){
    ){

        this.userAccountReposistory=userAccountReposistory;
        this.userAccountMapper = userAccountMapper;
        this.studentReposistory = studentReposistory;
        this.collageReposistory = collageReposistory;
        this.studentMapper = studentMapper;
        this.collageMapper = collageMapper;
//        this.studentService = studentService;
//        this.collageService = collageService;

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

    @Override
    public CurrentUserAccountReponse getCurrentAccountReponse(Authentication authentication) {

        String userName = authentication.getName();
        if(studentReposistory.existsByUserName(userName)){
            UserAccount userAccount= userAccountReposistory.findByUserName(userName);
            //StudentResponse studentResponse = studentService.getStudent(userName);
            Student student =studentReposistory.findByUserName(userName);
            StudentResponse studentResponse = studentMapper.toResponse(student);
            return userAccountMapper.toCurrentUserAccountResponse(userAccount,studentResponse);
        } else
        if(collageReposistory.existsByCode(userName)){
            UserAccount userAccount= userAccountReposistory.findByUserName(userName);
            //CollageResponse collageResponse = collageService.getCollage(userName);
            Collage collage = collageReposistory.findByCode(userName);
            CollageResponse collageResponse = collageMapper.toResponse(collage);
            return userAccountMapper.toCurrentUserAccountResponse(userAccount,collageResponse);
        }

        throw new RecordNotFoundException("Profile not found with : "+userName);
    }
}
