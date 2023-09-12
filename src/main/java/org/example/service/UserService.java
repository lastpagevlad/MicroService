package org.example.service;

import org.example.store.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    List<User> readAll();
    User read(int userId);
    User update(User user, int userId);
    void delete(int id);
}
