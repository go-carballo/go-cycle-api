package com.biciman.go.persistence.mapper;


import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.persistence.entity.BiciEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BiciMapper.class})
public interface BiciMapper {

    @Mapping(source = "marca", target = "titulo")
    @Mapping(source = "genero", target = "gener")
    @Mapping(source = "tipo", target = "tipo")
    BiciDto toDto(BiciEntity biciEntity);
    List<BiciDto> toDto(Iterable<BiciEntity> biciEntities);

    @InheritInverseConfiguration
    BiciEntity toEntity(BiciDto biciDto);

    /*@Mapping(target = "title", source = "titulo")
    @Mapping(target = "marca", source = "marca")
    @Mapping(target = "genero", source = "gener")
    @Mapping(target = "tipo", source = "tipo")
    void updateBiciFromDto(UpdateBiciDto updateBiciDto, @MappingTarget BiciEntity biciEntity);*/
}
