package gr.elenpapaio.CollegeREST.controller;

import gr.elenpapaio.CollegeREST.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

    @Autowired
    private CollegeService cs;

    @GetMapping("college")
    public String getIntro(){
        return "Welcome to our college website!";
    }

    @GetMapping("college/courses")
    public String getCourses(){
        return cs.getCourses().toString();
    }

    @GetMapping("college/students")
    public String getStudents(){
        return cs.getStudents().toString();
    }

    @GetMapping("college/student/{id}")
    public String getStudentId(@PathVariable int id){
        return cs.getStudentId(id).toString();
    }

    @GetMapping("college/student/{id}/modules")
    public String getModulesPerStudent(@PathVariable int id){
        return cs.getModulesPerStudent(id).toString();
    }

    @GetMapping("college/student/{id}/module/{modulename}/marks")
    public String getModuleMarks(@PathVariable int id, @PathVariable String modulename){
        return cs.getModuleMarks(id, modulename).toString();
    }

}
