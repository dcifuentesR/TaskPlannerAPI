package com.eci.TaskPlannerAPI.controller;

import com.eci.TaskPlannerAPI.model.User;
import com.eci.TaskPlannerAPI.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {
    
    @Autowired
    private UserService us;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(us.getAll(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(us.getUserById(userId), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            return new ResponseEntity<>(us.create(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
        
    }

    @RequestMapping(method = RequestMethod.PUT)//quiero poner el request para que sea /users/{id}, pero no puedo con el servicio update(user)
    public ResponseEntity<?> update(@RequestBody User user) {
        try {
            return new ResponseEntity<>(us.update(user), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable(name = "userId") String userId) {
        try {
            us.remove(userId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
