package com.biciman.go.domain.repository;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.persistence.entity.BiciEntity;

import java.util.List;

public interface BiciRepository {
    List<BiciDto> getAll();
}
