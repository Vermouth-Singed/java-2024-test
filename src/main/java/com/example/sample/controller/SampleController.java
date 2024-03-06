package com.example.sample.controller;

import com.example.sample.dto.response.SampleResponseDTO;
import com.example.sample.entity.NameEntity;
import com.example.sample.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sample")
@Tag(name = "샘플", description = "샘플 API")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping()
    @Operation(summary = "인터셉터 테스트", description = "로그인 상태확인")
    public SampleResponseDTO sample(HttpServletRequest httpServletRequest) {
        SampleResponseDTO sampleResponseDTO = new SampleResponseDTO();
        return sampleResponseDTO;
    }

    @GetMapping("/join")
    public SampleResponseDTO join(HttpServletRequest httpServletRequest) {
        SampleResponseDTO sampleResponseDTO = new SampleResponseDTO();

        List<NameEntity> list = sampleService.list2();

        return sampleResponseDTO;
    }
}
