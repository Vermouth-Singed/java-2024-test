package com.example.sample.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 요청")
public class LoginRequestDTO {

    @Schema(description = "이메일")
    private String email;
}
