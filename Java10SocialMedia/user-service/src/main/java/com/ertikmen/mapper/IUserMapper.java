package com.ertikmen.mapper;


import com.ertikmen.dto.request.UserProfileUpdateRequestDto;
import com.ertikmen.dto.request.UserSaveRequestDto;
import com.ertikmen.dto.response.UserProfileFindAllResponseDto;
import com.ertikmen.rabbitmq.model.RegisterElasticModel;
import com.ertikmen.rabbitmq.model.RegisterModel;
import com.ertikmen.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserProfile toUserProfile(UserSaveRequestDto dto);

    UserProfile toUserProfile(RegisterModel model);

    UserProfile toUserProfile(UserProfileUpdateRequestDto dto);

    @Mapping(source = "id",target="userProfileId")
    UserProfileFindAllResponseDto toUserProfileFindAllResponseDto(UserProfile userProfile);

    RegisterElasticModel toRegisterElasticModel(UserProfile userProfile);





}
