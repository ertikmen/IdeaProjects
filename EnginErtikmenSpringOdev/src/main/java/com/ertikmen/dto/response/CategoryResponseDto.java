package com.ertikmen.dto.response;

import com.ertikmen.repository.enums.ECategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {

    private Long id;
    private ECategoryType categoryType;
    private String description;


}
