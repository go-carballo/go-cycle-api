package com.biciman.go.domain.service;


import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.repository.BiciRepository;
import com.biciman.go.persistence.entity.BiciEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiciService {

    private BiciRepository biciRepository;

        public BiciService(BiciRepository biciRepository) {
        this.biciRepository = biciRepository;
    }

    public List<BiciDto> getAll(){
        return this.biciRepository.getAll();
    }
}
