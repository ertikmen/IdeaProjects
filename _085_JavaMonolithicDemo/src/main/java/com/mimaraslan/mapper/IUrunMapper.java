package com.mimaraslan.mapper;

import com.mimaraslan.dto.request.UrunSaveRequestDto;
import com.mimaraslan.dto.response.UrunFindAllResponseDto;
import com.mimaraslan.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUrunMapper {
    IUrunMapper INSTANCE= Mappers.getMapper(IUrunMapper.class);

    Urun toUrun(final UrunSaveRequestDto dto);
    UrunFindAllResponseDto fromUrun(final Urun urun);
}
