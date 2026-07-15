package com.example.visitorlog.Java.Service;

import com.example.visitorlog.Java.Entity.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {

    private List<Visitor> visitors = new ArrayList<>();

    public List<Visitor> getAllVisitors(){
        return visitors;
    }


    public Visitor getVisitorById(Long id) {
        return visitors.stream().filter(visitor -> visitor.getId().equals(id)).findFirst().orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Visitor not found"));
    }

}
