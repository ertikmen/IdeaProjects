package com.ertikmen.mapper;


import com.ertikmen.dto.response.UserResponseDto;
import com.ertikmen.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    UserResponseDto toUserResponseDto(User user);

    List<UserResponseDto> toUserResponseDtos(List<User> userList);

}
