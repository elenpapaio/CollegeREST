package gr.elenpapaio.CollegeREST.model;

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


    public void enroll(Module module) {
        // check if already enrolled in particular module
        for (MarkModule m : markModules) {
            if (m.getModule() == module) {
                System.out.println("Already enrolled in " + module);
                return;
            }
        }

        MarkModule markModule = new MarkModule();
        markModule.setModule(module);
        markModules.add(markModule);

        System.out.println("Successfully enrolled in " + module);
    }

    /**
     * calculate the average mark of the course by taking into account all the modules
     * and all the achieved marks in each module
     * @return average mark of the course
     */
    public double getAverageMark() {
        double sumOfAvgPerModule = 0;

        for (MarkModule m : markModules) {
            double sumAchievedMarks = 0;
            for (AchievedMark a : m.getAchievedMarks()) {
                sumAchievedMarks += a.getMark();
            }
            // get the sum of average marks of MarkModules
            sumOfAvgPerModule += sumAchievedMarks / m.getAchievedMarks().size();
        }
        return sumOfAvgPerModule / markModules.size();
    }

    public boolean checkIfAllModulesPassed() {
        for (MarkModule m : markModules) {
            double sumAchievedMarks = 0;
            for (AchievedMark a : m.getAchievedMarks()) {
                sumAchievedMarks += a.getMark();
            }
            double avgMark = sumAchievedMarks / m.getAchievedMarks().size();
            if (avgMark < 5) {
                return false;
            }
        }
        return true;
    }
}
