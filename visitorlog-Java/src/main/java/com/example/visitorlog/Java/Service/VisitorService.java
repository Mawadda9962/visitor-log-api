package com.example.visitorlog.Java.Service;

import com.example.visitorlog.Java.Entity.Visitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {

    private List<Visitor> visitors = new ArrayList<>();

    public List<Visitor> getAllVisitors(){
        return visitors;
    }

    private Visitor getVisitorById(){
       return visitors.stream()
    }
}
