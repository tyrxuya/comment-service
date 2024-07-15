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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SystemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenAdminEditCommentInputWithPathVariable_whenMockMVC_thenResponseOk() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void givenDeleteCommentInputWithPathVariable_whenMockMVC_thenResponseOk() throws Exception {
        DeleteCommentInput input = DeleteCommentInput.builder()
                .roomId("15")
                .build();

        mockMvc.perform(delete(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk());
    }

    @Test
    void givenAdminEditCommentInput_whenRoomNoIsBlank_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo(" ")
                .firstName("vanio")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenFirstNameIsBlank_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("     ")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenFirstNameIsLessThanMin_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("")
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenFirstNameIsMoreThanMax_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //55
                .lastName("doe")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenLastNameIsBlank_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("       ")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenLastNameIsLessThanMin_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("")
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenLastNameIsMoreThanMax_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //55
                .content("nqkakuv komentar")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenContentIsBlank_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("     ")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenContentIsLessThanMin_thenResponseIAmATeapot() throws Exception {
        AdminEditCommentInput input = AdminEditCommentInput.builder()
                .commentId("1234")
                .roomNo("15")
                .firstName("vanio")
                .lastName("doe")
                .content("")
                .build();

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenAdminEditCommentInput_whenContentIsMoreThanMax_thenResponseIAmATeapot() throws Exception {
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

        mockMvc.perform(put(RestApiPaths.SYSTEM + "/comment/12")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }
}