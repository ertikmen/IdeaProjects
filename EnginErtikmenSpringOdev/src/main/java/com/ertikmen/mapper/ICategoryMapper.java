package com.ertikmen.mapper;

import com.ertikmen.dto.response.CategoryResponseDto;
import com.ertikmen.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {

    ICategoryMapper INSTANCE= Mappers.getMapper(ICategoryMapper.class);

    CategoryResponseDto toCategoryResponseDto(Category category);

    List<CategoryResponseDto> toCategoryResponseDtos(List<Category> categoryList);
}
