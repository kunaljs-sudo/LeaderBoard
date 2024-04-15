package com.example.leaderboard.repositoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leaderboard.exception.BadDataProvidedException;
import com.example.leaderboard.exception.UserNotFoundException;
import com.example.leaderboard.models.User;
import com.example.leaderboard.repository.UserRepository;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> oUser = userRepository.findById(userId);
        if (oUser.isEmpty()) {
            throw new UserNotFoundException("No such user present with userId: " + userId);
        }
        User user = oUser.get();
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new BadDataProvidedException("There is problem with given user having userId" + user.getUserId());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
