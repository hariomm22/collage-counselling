package gov.counselling.collageCounselling.Service;

import gov.counselling.collageCounselling.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public List<Student> generateRank(List<Student> studentList) {

        studentList.sort(Comparator.comparingDouble(Student::getScore).reversed());
        int rank = 1;
        for (int i = 0; i < studentList.size(); i++) {
            if (i > 0 &&
                    studentList.get(i).getScore() != studentList.get(i - 1).getScore()) {
                rank = i + 1;
            }
            studentList.get(i).setRank(rank);
            System.out.println("Obj : "+ studentList.get(i));
        }
        return studentList;
    }
}
