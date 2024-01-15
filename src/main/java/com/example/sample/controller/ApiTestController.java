package com.example.sample.controller;

import com.example.sample.dto.response.LoginResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/api/connect")
@Tag(name = "외부 API", description = "외부 API 테스트")
public class ApiTestController {
    @GetMapping()
    @Operation(summary = "외부 API 테스트", description = "로그인 상태확인")
    public boolean sample() {
        try {
            URL url = new URL("http://localhost:8080/api/login");
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod(HttpMethod.GET.name());
            urlConn.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            LoginResponseDTO result = objectMapper.readValue(sb.toString().replaceAll("null", "124"), LoginResponseDTO.class);

            log.info("정상 : [{}], 현재 : [{}], 입력 데이터 : [{}]", HttpURLConnection.HTTP_OK, urlConn.getResponseCode(), result.toString());

            return HttpURLConnection.HTTP_OK == urlConn.getResponseCode();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return false;
    }
}
