package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentDataService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@RestController
@Controller
public class TemplatesController {
    @Autowired(required = true)
    private StudentDataService dataService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @PostMapping("/data/save")
    public RedirectView saveDataEntry(
            @RequestParam("rollno") String rollno,
            @RequestParam("name") String name,
            @RequestParam("year") String year,
            @RequestParam("courses") String courses
    ) {
        Student dataEntry = new Student();
        dataEntry.setId(new ObjectId()); // Generates a new ObjectId
        dataEntry.setRollno(rollno);
        dataEntry.setName(name);
        dataEntry.setYear(year);
        dataEntry.setCourses(courses);
        dataEntry.setDate(LocalDateTime.now()); // Sets the current date and time

        dataService.saveEntry(dataEntry); // Save the entry to MongoDB

        return new RedirectView("/landing"); // Redirects to the homepage or another page after submission
    }
}
