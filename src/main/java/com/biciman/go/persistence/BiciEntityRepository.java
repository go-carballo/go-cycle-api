package com.biciman.go.persistence;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.domain.exception.BiciAlreadyExist;
import com.biciman.go.domain.exception.BiciNotFound;
import com.biciman.go.domain.repository.BiciRepository;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import com.biciman.go.persistence.entity.Bicicleta;
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
        Bicicleta bicicleta = this.crudBiciclyEntiy.findById(id).orElse(null);
        return this.biciMapper.toDto(bicicleta);
    }

    @Override
    public BiciDto save(BiciDto biciDto) {
        if (this.crudBiciclyEntiy.findFirstBymarca(biciDto.marca()) != null) {
            throw new BiciAlreadyExist(biciDto.marca());

        }
        Bicicleta bicicleta = this.biciMapper.toEntity(biciDto);
        bicicleta.setEstado("Disponible");
        return this.biciMapper.toDto(this.crudBiciclyEntiy.save(bicicleta));
    }

    @Override
    public BiciDto update(long id, UpdateBiciDto updateBiciDto) {
        Bicicleta bicicleta = this.crudBiciclyEntiy.findById(id).orElse(null);
        if (bicicleta == null) {
            throw new BiciNotFound(id);
        }
        bicicleta.setMarca(updateBiciDto.titulo());
        return this.biciMapper.toDto(this.crudBiciclyEntiy.save(bicicleta));
    }

    @Override
    public void delete(long id) {
        Bicicleta bicicleta = this.crudBiciclyEntiy.findById(id).orElse(null);
        if (bicicleta == null) {
            throw new BiciNotFound(id);
        }
        this.crudBiciclyEntiy.deleteById(id);

         this.biciMapper.toDto(bicicleta);
    }
}


