package com.biciman.go.web.controller;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.dto.SuggestRequestDto;
import com.biciman.go.domain.dto.UpdateBiciDto;
import com.biciman.go.domain.service.BiciService;
import com.biciman.go.domain.service.GoBicimanAiService;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
public class BiciController {

    private final BiciService biciService;

    private final GoBicimanAiService goBicimanAiService;

    public BiciController(CrudBiciclyEntiy crudBiciclyEntiy, BiciService biciService, GoBicimanAiService goBicimanAiService) {
        this.biciService = biciService;
        this.goBicimanAiService = goBicimanAiService;
    }

    @GetMapping
    public ResponseEntity <List<BiciDto>> getAll() {
        return ResponseEntity.ok(this.biciService.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<BiciDto> getById(@PathVariable Long id){
        BiciDto biciDto = this.biciService.getById(id);
        if (biciDto == null) {
            return ResponseEntity.notFound().build();
        }
         return  ResponseEntity.ok().body(biciDto);
    }

    @PostMapping("/suggest")
    ResponseEntity<String> generateBiciclesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
        return ResponseEntity.ok(this.goBicimanAiService.GenerateBiciSuggestion(suggestRequestDto.userPreferences()));

    }

    @PostMapping()
    public ResponseEntity<BiciDto> save(@RequestBody BiciDto biciDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.biciService.save(biciDto));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<BiciDto> update(@PathVariable long id, @RequestBody UpdateBiciDto updateBiciDto){
        return ResponseEntity.ok(this.biciService.update(id, updateBiciDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        this.biciService.delete(id);
        return ResponseEntity.ok().build();
    }
}
