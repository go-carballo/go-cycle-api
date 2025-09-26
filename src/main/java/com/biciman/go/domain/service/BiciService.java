package com.biciman.go.domain.service;


import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.domain.repository.BiciRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiciService {

    private BiciRepository biciRepository;

    public BiciService(BiciRepository biciRepository) {
        this.biciRepository = biciRepository;
    }


    @Tool("Busca todas las bicicletas que exista dentro de la plataforma")
    public List<BiciDto> getAll() {
        return this.biciRepository.getAll();
    }
    public BiciDto getById(long id) {
        return this.biciRepository.getById(id);
    }

    public BiciDto save(BiciDto biciDto) {
        return this.biciRepository.save(biciDto);
    }
    public BiciDto update(long id, UpdateBiciDto updateBiciDto) {
        return this.biciRepository.update(id, updateBiciDto);
    }
    public void delete(long id) {
        this.biciRepository.delete(id);
    }
}
