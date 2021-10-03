package com.wateroflife.store;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StoreRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @DisplayName("매장 저장 성공")
    void saveStoreSuccess() throws Exception {

        //Given
        String url = "/api/store";
        Map<String,Object> storeParam = new HashMap<>();
        storeParam.put("location", "서울시");
        storeParam.put("brand", "이마트");
        storeParam.put("name", "송파점");
        storeParam.put("tel", "02-1111-2222");


        //When
        ResultActions actions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(storeParam))
        );


        //Then
        actions.andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("매장 저장 실패")
    void saveStoreFail() throws Exception {

        //Given
        String url = "/api/store";
        Map<String,Object> storeParam = new HashMap<>();
        storeParam.put("id", "2");
        storeParam.put("location", "서울시");
        storeParam.put("brand", "이마트");
        storeParam.put("name", "송파점");
        storeParam.put("tel", "02-1111-2222");


        //When
        ResultActions actions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(storeParam))
        );


        //Then
        actions.andDo(print())
                .andExpect(status().isOk());

    }



}