package gr.codehub.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Module {
    private String name;
    private Course course;
    private String assignedTutor;
    private ModuleType moduleType;
}
