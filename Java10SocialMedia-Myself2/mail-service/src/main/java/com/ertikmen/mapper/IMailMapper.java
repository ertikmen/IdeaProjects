package com.ertikmen.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMailMapper {

    IMailMapper INSTANCE = Mappers.getMapper(IMailMapper.class);






}
