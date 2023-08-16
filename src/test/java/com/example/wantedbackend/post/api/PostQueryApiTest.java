package com.example.wantedbackend.post.api;

import com.example.wantedbackend.post.service.PostQueryUsecase;
import com.example.wantedbackend.support.BaseApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


class PostQueryApiTest extends BaseApiTest {

    @Autowired
    PostQueryUsecase postQueryUsecase;

    @Test
    void 전체_조회_요청_성공() throws Exception {

//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/posts/list")
//                        .param("page", "0")
//                        .param("size", "5")
//                        .param("sort", "createdAt,desc")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(MockMvcResultMatchers.status().isOk());

    }

}
