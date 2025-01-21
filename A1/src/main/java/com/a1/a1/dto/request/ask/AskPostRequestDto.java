package com.a1.a1.dto.request.ask;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AskPostRequestDto {

    @NotNull
    private int askSort;
    @NotBlank
    private String askTitle;
    @NotBlank
    private String askContent;

}