package gr.codehub.college.model;

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

}
