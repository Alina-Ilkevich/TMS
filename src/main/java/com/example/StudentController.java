package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get")
    public String getAllStudent(Model model){
        List<Student> students = studentService.findStudent();
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("/getunpaidstudent")
    public String getUnpaidStudent(Model model){
        List<Student> students = studentService.findByPaymentFalse();
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("/getbygroupname")
    public String getStudentByName(@RequestParam String name, Model model){
        List<Student> students =  studentService.findStudentByName(name);
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("/getbygroupsurname")
    public String getStudentBySurname(@RequestParam String surname, Model model){
        List<Student> students =  studentService.findStudentBySurname(surname);
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("/getbygroupnumber")
    public String getStudentByGroupName(@RequestParam int groupNumber, Model model){
        List<Student> students =  studentService.findStudentByGroupName(groupNumber);
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("/deletebyid")
    public String deleteStudentById(@RequestParam int id, Model model){
        Student student = studentService.findById(id);
        if(student != null){
            studentService.deleteStudentById(id);
            model.addAttribute("message", "The student with ID " + id + " was deleted");
        }else {
            model.addAttribute("message", "The student with ID " + id + " does not exist");
        }
        return "delete";
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "student", new Student());
    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute Student student, Model model){
        studentService.save(student);
        model.addAttribute("message", "The student with name " + student.getName() + " created successful");
        return new ModelAndView ("create_result", "model", model);
    }

    @GetMapping(value = "/update")
    public ModelAndView showUpdateForm() {
        return new ModelAndView("update", "student", new Student());
    }

    @PostMapping("/update")
    public ModelAndView updateStudent(@ModelAttribute Student student, Model model){
        studentService.save(student);
        model.addAttribute("message", "The student with name " + student.getName() + " updated successful");
        return new ModelAndView ("create_result", "model", model);
    }
}
