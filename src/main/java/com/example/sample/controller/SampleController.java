package com.example.sample.controller;

import com.example.sample.dto.response.SampleResponseDTO;
import com.example.sample.enums.LoginEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/sample")
@Tag(name = "샘플", description = "샘플 API")
public class SampleController {
    @GetMapping()
    @Operation(summary = "인터셉터 테스트", description = "로그인 상태확인")
    public SampleResponseDTO sample(HttpServletRequest httpServletRequest) {
        SampleResponseDTO sampleResponseDTO = new SampleResponseDTO();
        sampleResponseDTO.setSuccess(httpServletRequest.getAttribute(LoginEnum.INTERCEPTOR.code()) == null);
        log.info("로그인 " + (sampleResponseDTO.isSuccess() ? "된" : "안된") + "상태");
        return sampleResponseDTO;
    }
}
