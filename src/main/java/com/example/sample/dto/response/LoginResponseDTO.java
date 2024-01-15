package com.example.sample.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "로그인 응답")
public class LoginResponseDTO extends CommonResponseDTO {

    @Schema(description = "이메일")
    private String email;
}
