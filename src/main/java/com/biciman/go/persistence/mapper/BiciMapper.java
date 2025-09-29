package com.biciman.go.persistence.mapper;


import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.persistence.entity.Bicicleta;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BiciMapper.class})
public interface BiciMapper {


    @Mapping(source = "genero", target = "gener")
    @Mapping(source = "tipo", target = "tipo")
    BiciDto toDto(Bicicleta bicicleta);
    List<BiciDto> toDto(Iterable<Bicicleta> bicicleta);

    @InheritInverseConfiguration
    Bicicleta toEntity(BiciDto biciDto);

   /* @Mapping(target = "title", source = "titulo")
    @Mapping(target = "genero", source = "gener")
    @Mapping(target = "tipo", source = "tipo")
    void updateBiciFromDto(UpdateBiciDto updateBiciDto, @MappingTarget Bicicleta bicicleta);*/
}
