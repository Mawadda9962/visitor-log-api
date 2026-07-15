package com.example.visitorlog.Java.Controller;

import com.example.visitorlog.Java.Entity.Visitor;
import com.example.visitorlog.Java.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/visitors")
    public Visitor addVisitor(@RequestBody Visitor visitor){
        return  visitorService.addVisitor(visitor);
    }

    @DeleteMapping("/visitors/{id")
    public String deleteVisitor(@PathVariable Long id){
       visitorService.deleteVisitor(id);
       return "Visitor Deleted Successfully";
    }

    @GetMapping("/visitors/count")
    public int countVisitors(){
        return visitorService.countVisitor();
    }

    @GetMapping(value = "/visitors", params = "purpose")
    public List<Visitor> getVisitorsByPurpose(@RequestParam String purpose){
        return visitorService.getVisitorsByPurpose(purpose);
    }


    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(@PathVariable Long id, @RequestBody Visitor visitor){
        return visitorService.updateVisitor(id, visitor);
    }
}
