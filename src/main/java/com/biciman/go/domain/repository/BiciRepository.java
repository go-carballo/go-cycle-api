package com.biciman.go.domain.repository;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;

import java.util.List;

public interface BiciRepository {
    List<BiciDto> getAll();
    BiciDto getById(long id);
    BiciDto save(BiciDto biciDto);
    BiciDto update(long id, UpdateBiciDto updateBiciDto);
    void delete(long id);
}
