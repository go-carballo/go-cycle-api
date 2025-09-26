package com.biciman.go.persistence;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.domain.repository.BiciRepository;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import com.biciman.go.persistence.entity.BiciEntity;
import com.biciman.go.persistence.mapper.BiciMapper;
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

    @Override
    public BiciDto getById(long id) {
        BiciEntity biciEntity = this.crudBiciclyEntiy.findById(id).orElse(null);
            return this.biciMapper.toDto(biciEntity);
    }

    @Override
    public BiciDto save(BiciDto biciDto) {
        BiciEntity biciEntity = this.biciMapper.toEntity(biciDto);
        biciEntity.setEstado("Disponible");
        return this.biciMapper.toDto(this.crudBiciclyEntiy.save(biciEntity));
    }

    @Override
    public BiciDto update(long id, UpdateBiciDto updateBiciDto) {
        BiciEntity biciEntity = this.crudBiciclyEntiy.findById(id).orElse(null);
        if (biciEntity == null) {
            return null;
        }
        biciEntity.setMarca(updateBiciDto.titulo());
        return this.biciMapper.toDto(this.crudBiciclyEntiy.save(biciEntity));
    }

    @Override
    public void delete(long id) {
        this.crudBiciclyEntiy.deleteById(id);

    }


}
