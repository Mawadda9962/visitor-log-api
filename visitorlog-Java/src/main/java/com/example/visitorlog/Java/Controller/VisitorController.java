package com.example.visitorlog.Java.Controller;

import com.example.visitorlog.Java.Entity.Visitor;
import com.example.visitorlog.Java.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    VisitorService visitorService;


    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors(){
        return visitorService.getAllVisitors();
    }

    @GetMapping("/visirots/{id}")
    public Visitor getVisitorById(@PathVariable Long id){
        return visitorService.getVisitorById(id);
    }
}
