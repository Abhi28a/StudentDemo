package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Component
public class StudentDataService {
    @Autowired
    private StudentRepo studentRepo;
    public void saveEntry(Student dataEntry){
        studentRepo.save(dataEntry);
    }

}
