package com.example.visitorlog.Java.Service;

import com.example.visitorlog.Java.Entity.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VisitorService {

    private List<Visitor> visitors = new ArrayList<>();

    //automatically generating unique id
    private final AtomicLong visitorId = new AtomicLong(1);

    public List<Visitor> getAllVisitors(){
        return visitors;
    }


    public Visitor getVisitorById(Long id) {

        for (Visitor visitor : visitors) {
            if (visitor.getId().equals(id)) {
                return visitor;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Visitor not found"
        );
    }

    public Visitor addVisitor(Visitor visitor){
        visitor.setId(visitorId.getAndIncrement());
        visitors.add(visitor);
        return visitor;
    }

    public void deleteVisitor (Long id){
        Visitor visitorToDelete = null;

        for (Visitor visitor : visitors){
            if (visitor.getId().equals(id))
                visitorToDelete = visitor;
        }
        if(visitorToDelete == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Visitor not found"
            );
        }
        visitors.remove(visitorToDelete);
    }

}


}
