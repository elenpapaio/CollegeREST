package gr.codehub.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class Student {
    private int id;
    private Course course;
    private List<MarkModule> markModules;

    public Student() {
        markModules = new ArrayList<>();
    }

}
