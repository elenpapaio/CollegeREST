package gr.codehub.CollegeREST.service;

import gr.codehub.CollegeREST.model.Module;
import gr.codehub.CollegeREST.model.Course;
import gr.codehub.CollegeREST.model.Student;
import gr.codehub.CollegeREST.repository.CollegeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * service containing the logic for filtering and obtaining data
 * for the needs of CollegeController
 */
@Service
public class CollegeService {

    public List<Course> getCourses(){
        return new CollegeRepo("classpath:college.json").getCollege().getStudents()
                .stream()
                .map(s -> s.getCourse())
                .collect(Collectors.toList());
    }

    public List<Student> getStudents(){
        return new CollegeRepo("classpath:college.json").getCollege().getStudents();
    }

    public Student getStudentId(int id){
        return this.getStudents()
                .stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .get();
    }

    public List<Module> getModulesPerStudent(int id){
        return this.getStudentId(id).getMarkModules()
                .stream()
                .map(markModule -> markModule.getModule())
                .collect(Collectors.toList());
    }

    public List<Integer> getModuleMarks(int id, String modulename){
        return this.getStudentId(id).getMarkModules()
                .stream()
                .filter(markModule -> markModule.getModule().getName().equals(modulename))
                .findFirst()
                .get()
                .getAchievedMarks()
                .stream()
                .map(achievedMark -> achievedMark.getMark())
                .collect(Collectors.toList());
    }
}
