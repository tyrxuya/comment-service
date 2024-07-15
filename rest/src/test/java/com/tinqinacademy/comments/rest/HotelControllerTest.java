package com.tinqinacademy.comments.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenGetCommentsInputWithPathVariable_whenMockMVC_thenReturnOk() throws Exception {
        String roomId = "12";

        GetCommentsInput input = GetCommentsInput.builder()
                .roomId(roomId)
                .build();

        mockMvc.perform(get(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comments").exists())
                .andExpect(jsonPath("$.comments[0].id").value("12312"))
                .andExpect(jsonPath("$.comments[0].firstName").value("vanio"))
                .andExpect(jsonPath("$.comments[0].lastName").value("ivanov"))
                .andExpect(jsonPath("$.comments[0].publishDate").value(LocalDate.now().plusDays(3).toString()))
                .andExpect(jsonPath("$.comments[0].lastEditedBy").value("admin"))
                .andExpect(jsonPath("$.comments[0].lastEditedDate").value(LocalDate.now().plusDays(3).toString()));
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenMockMVC_thenReturnCreated() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("ivanov")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenFirstNameIsBlank_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("    ")
                .lastName("ivanov")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenFirstNameIsLessThanMin_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("")
                .lastName("ivanov")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenFirstNameIsMoreThanMax_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //51
                .lastName("ivanov")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenLastNameIsBlank_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("     ")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenLastNameIsLessThanMin_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("")
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenLastNameIsMoreThanMax_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") //51
                .content("nqmam kakvo da kaja, top obslujvane")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenContentIsBlank_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("ivanov")
                .content("      ")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenContentIsLessThanMin_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("ivanov")
                .content("")
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenCreateCommentInputWithPathVariable_whenContentIsMoreThanMax_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        CreateCommentInput input = CreateCommentInput.builder()
                .roomId(roomId)
                .firstName("vanio")
                .lastName("ivanov")
                .content("""
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        """)
                .build();

        mockMvc.perform(post(RestApiPaths.HOTEL + "/" + roomId + RestApiPaths.COMMENT)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }


    @Test
    void givenUserEditCommentInputWithPathVariable_whenMockMVC_thenReturnOk() throws Exception {
        String roomId = "12";

        UserEditCommentInput input = UserEditCommentInput.builder()
                .content("proba")
                .build();

        mockMvc.perform(patch(RestApiPaths.HOTEL_COMMENT + "/" + roomId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty());

    }

    @Test
    void givenUserEditCommentInputWithPathVariable_whenContentIsBlank_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        UserEditCommentInput input = UserEditCommentInput.builder()
                .content("     ")
                .build();

        mockMvc.perform(patch(RestApiPaths.HOTEL_COMMENT + "/" + roomId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenUserEditCommentInputWithPathVariable_whenContentIsLessThanMin_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        UserEditCommentInput input = UserEditCommentInput.builder()
                .content("")
                .build();

        mockMvc.perform(patch(RestApiPaths.HOTEL_COMMENT + "/" + roomId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    void givenUserEditCommentInputWithPathVariable_whenContentIsMoreThanMax_thenReturnIAmATeapot() throws Exception {
        String roomId = "12";

        UserEditCommentInput input = UserEditCommentInput.builder()
                .content("""
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        """)
                .build();

        mockMvc.perform(patch(RestApiPaths.HOTEL_COMMENT + "/" + roomId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isIAmATeapot());
    }


}