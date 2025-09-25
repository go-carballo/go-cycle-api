package com.biciman.go.persistence;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.repository.BiciRepository;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import com.biciman.go.persistence.persistence.mapper.BiciMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiciEntityRepository implements BiciRepository {
    private final CrudBiciclyEntiy crudBiciclyEntiy;
    private final BiciMapper biciMapper;

    public BiciEntityRepository(CrudBiciclyEntiy crudBiciclyEntiy, BiciMapper biciMapper) {
        this.crudBiciclyEntiy = crudBiciclyEntiy;
        this.biciMapper = biciMapper;
    }

    @Override
    public List<BiciDto> getAll() {
        return this.biciMapper.toDto(this.crudBiciclyEntiy.findAll());
    }
}
