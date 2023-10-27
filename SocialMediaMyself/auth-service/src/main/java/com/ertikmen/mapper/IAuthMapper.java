package com.ertikmen.mapper;


import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE= Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(Auth auth);

}
