package com.biciman.go.persistence.persistence.mapper;


import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.persistence.entity.BiciEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BiciMapper.class})
public interface BiciMapper {

    @Mapping(source = "marca", target = "titulo")
    @Mapping(source = "genero", target = "gener")
    @Mapping(source = "tipo", target = "tipo")
    BiciDto toDto(BiciEntity biciEntity);
    List<BiciDto> toDto(Iterable<BiciEntity> biciEntities);
}
