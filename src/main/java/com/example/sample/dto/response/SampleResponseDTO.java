package com.example.sample.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "샘플 DTO")
public class SampleResponseDTO extends CommonResponseDTO {
}
