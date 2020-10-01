package com.eci.TaskPlannerAPI.service;

import java.util.List;

import com.eci.TaskPlannerAPI.model.User;

public interface UserService {
    public List<User> getAll();

    public User getUserById(String userId);

    public User create(User user);

    public User update(User user);

    void remove(String userId);
}
