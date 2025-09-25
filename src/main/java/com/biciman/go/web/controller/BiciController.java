package com.biciman.go.web.controller;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.service.BiciService;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiciController {

    private final BiciService biciService;

    public BiciController(CrudBiciclyEntiy crudBiciclyEntiy, BiciService biciService) {
        this.biciService = biciService;
    }

    @GetMapping("/bicicletas")
    public List<BiciDto> getAll(){
        return  this.biciService.getAll();
    }
}
