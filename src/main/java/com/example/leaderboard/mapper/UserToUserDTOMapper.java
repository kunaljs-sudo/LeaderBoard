package com.example.leaderboard.mapper;

import java.util.List;

import com.example.leaderboard.dto.UserDTO;
import com.example.leaderboard.models.User;

public interface UserToUserDTOMapper {
    public UserDTO convertUser(User user);

    public List<UserDTO> convertUsers(List<User> users);
}
