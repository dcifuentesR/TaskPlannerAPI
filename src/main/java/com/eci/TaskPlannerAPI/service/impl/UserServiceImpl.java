package com.eci.TaskPlannerAPI.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eci.TaskPlannerAPI.model.User;
import com.eci.TaskPlannerAPI.service.UserService;

public class UserServiceImpl implements UserService {

    ArrayList<User> users = (ArrayList<User>) Arrays
            .asList(new User[] { new User("dcifuentes", "daniel.cifuentes-r@mail.escuelaing.edu.co"),
                    new User("Oscar", "oscar.mendez-z@escuelaing.edu.co"),
                    new User("Claudia", "claudia.santiago@escuelaing.edu.co"),
                    new User("Dagoberto", "dagoberto.borda@escuelaing.edu.co") });
    
    ;

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        for (User u : users) {
            if(u.getUserId().equals(user.getUserId())){
                users.remove(u);
                users.add(user);
            }
        }
        
        return user;
    }

    @Override
    public void remove(String userId) {
        for (User user : users) {
            if(user.getUserId().equals(userId)){
                users.remove(user);
            }
        }

    }

    @Override
    public User getUserById(String userId) {
        User resp = null;

        for (User user : users) {
            if(user.getUserId().equals(userId)){
                resp=user;
            }
        }
        return resp;
    }
    
}
