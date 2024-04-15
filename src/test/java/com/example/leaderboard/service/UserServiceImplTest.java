package com.example.leaderboard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.leaderboard.LeaderboardApplication;
import com.example.leaderboard.dto.UserDTO;
import com.example.leaderboard.exchanges.GetUserResponse;
import com.example.leaderboard.mapper.UserToUserDTOMapper;
import com.example.leaderboard.models.User;
import com.example.leaderboard.repositoryService.UserRepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { LeaderboardApplication.class })
@DirtiesContext
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ActiveProfiles("test")
public class UserServiceImplTest {
    public static final String leaderboardAPI = "/users";

    @MockBean
    UserRepositoryService userRepositoryService;

    @MockBean
    UserToUserDTOMapper mapper;

    @InjectMocks
    UserServiceImpl userService;

    private ObjectMapper objectMapper;
    // private MockMvc mvc;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();

        MockitoAnnotations.openMocks(this);

        // mvc = MockMvcBuilders.standaloneSetup(userServiceImpl).build();
    }

    public User getTempUser() {
        User user = new User();
        user.setUserId("abc1234");
        user.setUsername(anyString());
        user.setScore(0.0);
        user.setBadges(new ArrayList<>());
        return user;
    }

    public UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        // User user = getTempUser();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setScore(user.getScore());
        userDTO.setBadges(user.getBadges());
        return userDTO;
    }

    @Test
    public void getUserByIdTest() {
        User user = getTempUser();
        UserDTO userDTO = getUserDTO(user);
        when(userRepositoryService.getUser("abc1234")).thenReturn(user);
        when(mapper.convertUser(user)).thenReturn(userDTO);
        GetUserResponse expectedUserResponse = new GetUserResponse(userDTO);

        assertEquals(userService.getUserById(anyString()), expectedUserResponse);
    }
}
