package com.capgemini.wsb.fitnesstracker.statistics;

import com.capgemini.wsb.fitnesstracker.IntegrationTest;
import com.capgemini.wsb.fitnesstracker.IntegrationTestBase;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDate.now;
import static java.util.UUID.randomUUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@Transactional
@AutoConfigureMockMvc(addFilters = false)
public class StatisticsApiIntegrationTest extends IntegrationTestBase  {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldPersistStatistics_whenCreatingNewStatistics() throws Exception {

        User user1 = existingUser(generateClient());

        String requestBody = """
                {
                    "userId": "%s",
                    "totalTrainings": 3,
                    "totalDistance": 8.2,
                    "totalCaloriesBurned": 1245
                }
                """.formatted(user1.getId());
        mockMvc.perform(post("/v1/statistics").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andDo(log())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.user.id").value(user1.getId()))
                .andExpect(jsonPath("$.user.firstName").value(user1.getFirstName()))
                .andExpect(jsonPath("$.user.lastName").value(user1.getLastName()))
                .andExpect(jsonPath("$.user.email").value(user1.getEmail()))
                .andExpect(jsonPath("$.totalTrainings").value(3))
                .andExpect(jsonPath("$.totalDistance").value(8.2))
                .andExpect(jsonPath("$.totalCaloriesBurned").value(1245));

    }

    private static User generateClient() {
        return new User(randomUUID().toString(), randomUUID().toString(), now(), randomUUID().toString());
    }

}
