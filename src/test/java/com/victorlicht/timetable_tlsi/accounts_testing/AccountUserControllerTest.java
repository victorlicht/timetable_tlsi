package com.victorlicht.timetable_tlsi.accounts_testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testCreateAccountUser() throws Exception {
        String requestBody = "{\"username\": \"test2\", \"firstName\": \"Joddddhn\", \"lastName\": \"Ddddoe\", \"email\": \"test@edaddmple.com\", "
                + "\"password\": \"userdPasswdord\", \"confirmationPassword\": \"userPasddsword\", "
                + "\"gender\": \"MALE\", \"wilaya\": \"CONSTANTINE\", "
                + "\"dateOfBirth\": \"1990-11-11\", \"biography\": \"Some bdiography text\", "
                + "\"profilePicture\": \"profdil.djpg\", \"phoneNumber\": \"1245567890\"}";

        mockMvc.perform(post("/api/v1/admin/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("test2"));
    }
    @Test
    @Order(2)
    public void testFindUsersDynamically() throws Exception {
        mockMvc.perform(get("/api/v1/admin/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].username").value("testUser"));
    }

    @Test
    @Order(3)
    public void testUpdateAccountUserByUsername() throws Exception {
        String requestBody = "{\"firstName\": \"UpdatedFirstName\"}";
        mockMvc.perform(put("/api/v1/admin/users/update/{username}", "testUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testUser"))
                .andExpect(jsonPath("$.firstName").value("UpdatedFirstName"));
    }
}

