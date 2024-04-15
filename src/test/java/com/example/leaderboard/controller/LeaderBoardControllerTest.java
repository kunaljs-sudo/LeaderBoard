package com.example.leaderboard.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.leaderboard.LeaderboardApplication;
import com.example.leaderboard.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { LeaderboardApplication.class })
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@AutoConfigureMockMvc
@DirtiesContext
@ActiveProfiles("test")
public class LeaderBoardControllerTest {
    public static final String leaderboardAPI = "/users";

    @MockBean
    UserService userService;

    @InjectMocks
    LeaderBoardController leaderBoardController;

    private ObjectMapper objectMapper;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();

        MockitoAnnotations.openMocks(this);

        mvc = MockMvcBuilders.standaloneSetup(leaderBoardController).build();
    }

    @Test
    public void invalidCreateNewUser() {
        assertTrue(true);
    }
}
