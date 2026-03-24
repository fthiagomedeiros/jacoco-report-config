package com.example.jacocotestproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class JacocoIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldBeCreatedWhenRequestIsSuccess() throws Exception {
        this.mockMvc.perform(post("/api/v1/test"))
                .andExpect(status().isCreated())
                .andDo(print());
    }

}
