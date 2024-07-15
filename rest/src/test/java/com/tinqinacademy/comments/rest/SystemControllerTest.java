package com.tinqinacademy.comments.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SystemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldRespondWithOkAndAdminEditCommentOutput() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    void shouldRespondWithOkAndDeleteCommentOutput() throws Exception {
        DeleteCommentInput input = DeleteCommentInput.builder()
                .roomId("15")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.delete(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRespondWithImATeapotWhenRoomNoIsInvalid() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo(" ")
                .firstName("vanio")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenFirstNameIsBlank() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("     ")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenFirstNameIsLessThanMin() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenFirstNameIsMoreThanMax() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //55
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenLastNameIsBlank() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("     ")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenLastNameIsLessThanMin() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenLastNameIsMoreThanMax() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //55
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenContentIsBlank() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("     ")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenContentIsLessThanMin() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }

    @Test
    void shouldRespondWithImATeapotWhenContentIsMoreThanMax() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("""
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        """) //201
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
    }
}