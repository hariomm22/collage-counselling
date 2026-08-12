package gov.counselling.collageCounselling.Service;

import gov.counselling.collageCounselling.Entity.Collage;
import gov.counselling.collageCounselling.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

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
         }
        return studentList;
    }

    public List<Student> createAllotement(List<Student> studentList, List<Collage> collageList) {

        studentList.sort(Comparator.comparingLong(Student::getRank));
        for(Student student : studentList){
            for(int id : student.getChoice()){
                Collage currentCllg = getCollageById(id,collageList);
                 if (currentCllg.getSeat()>=1){
                    currentCllg.setSeat(currentCllg.getSeat()-1);
                    student.setAllocate(currentCllg);
                    break;
                }
            }
        }
        return studentList;
    }

    public Collage getCollageById(int id,List<Collage> collageList){
        for(Collage collage : collageList){
            if(collage.getId()==id){
                 return collage;
             }
        }
        return null;
    }

}
