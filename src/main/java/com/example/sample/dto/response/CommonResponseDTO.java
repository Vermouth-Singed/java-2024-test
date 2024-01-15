package com.example.sample.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponseDTO {

    @Schema(description = "성공여부")
    private boolean success;

    @Schema(description = "실패코드")
    private String code;
}
