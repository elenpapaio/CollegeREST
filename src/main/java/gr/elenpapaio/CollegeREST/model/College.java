package gr.elenpapaio.CollegeREST.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class College {
    private List<Student> students;

    public College(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public double calculateStudentsAvgMarks(){
        return students.stream().map(s -> s.getAverageMark()).reduce(0.,Double::sum)/students.size();
    }

}
