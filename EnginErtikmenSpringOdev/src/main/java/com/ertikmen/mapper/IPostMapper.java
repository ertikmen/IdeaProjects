package com.ertikmen.mapper;


import com.ertikmen.dto.response.PostResponseDto;
import com.ertikmen.dto.response.UserResponseDto;
import com.ertikmen.repository.entity.Post;
import com.ertikmen.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {

    IPostMapper INSTANCE= Mappers.getMapper(IPostMapper.class);

    UserResponseDto toPostResponseDto(Post post);

    List<PostResponseDto> toPostResponseDtos(List<Post> postList);

}
