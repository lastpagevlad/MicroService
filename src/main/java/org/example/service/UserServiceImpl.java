package org.example.service;

import org.example.store.entity.User;
import org.example.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service //почитай про аннотацию
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public User update(User user, int userId) {
        var updateUser = userRepository.findById(userId).orElseThrow();
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setLastname(user.getLastname());
        updateUser.setEmail(user.getEmail());
        return userRepository.save(updateUser); //тестовое
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
