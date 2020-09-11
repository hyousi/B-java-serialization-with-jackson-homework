package com.thoughtworks.capability.gtb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetEventById() throws Exception {
        mockMvc.perform(get("/events/1")
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("utf-8"))
            .andExpect(jsonPath("$.id", is("1")))
            .andExpect(jsonPath("$.name", is("下载文件")))
            .andExpect(jsonPath("$.type", is("D")))
            .andExpect(jsonPath("$.time", instanceOf(Long.class)))
            .andExpect(jsonPath("$.userId", is("3")))
            .andExpect(jsonPath("$.userName", is("张三")));
    }

    @Test
    public void shouldCreateEvent() throws Exception {
        String request = "{\n"
            + "    \"id\": \"1\",\n"
            + "    \"name\": \"下载文件\",\n"
            + "    \"type\": \"D\",\n"
            + "    \"time\": 1599811597319,\n"
            + "    \"userId\": \"3\",\n"
            + "    \"userName\": \"张三\"\n"
            + "}";

        mockMvc.perform(post("/events")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request));
    }
}
