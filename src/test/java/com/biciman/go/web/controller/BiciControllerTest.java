package com.biciman.go.web.controller;

import com.biciman.go.domain.dto.BiciDto;
import com.biciman.go.domain.service.BiciService;
import com.biciman.go.domain.service.GoBicimanAiService;
import com.biciman.go.persistence.crud.CrudBiciclyEntiy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BiciControllerTest {

    @Mock
    private BiciService biciService;

    @Mock
    private GoBicimanAiService goBicimanAiService;

    @Mock
    private CrudBiciclyEntiy crudBiciclyEntiy;

    @InjectMocks
    private BiciController biciController;

    private BiciDto mockBici;

    @BeforeEach
    void setUp() {
        mockBici = new BiciDto(
            "Mountain Bike XC",
            "Trek",
            "Unisex",
            "Mountain"
        );
    }

    @Test
    @DisplayName("Should return bicycle when exists")
    void getById_WhenBiciExists_ReturnsOkWithBici() {
        // Arrange
        Long id = 1L;
        when(biciService.getById(id)).thenReturn(mockBici);

        // Act
        ResponseEntity<BiciDto> response = biciController.getById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mockBici, response.getBody());
        verify(biciService, times(1)).getById(id);
    }

    @Test
    @DisplayName("Should return not found when bicycle doesn't exist")
    void getById_WhenBiciNotExists_ReturnsNotFound() {
        // Arrange
        Long id = 999L;
        when(biciService.getById(id)).thenReturn(null);

        // Act
        ResponseEntity<BiciDto> response = biciController.getById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(biciService, times(1)).getById(id);
    }

    @Test
    @DisplayName("Should handle negative ID gracefully")
    void getById_WhenNegativeId_ReturnsNotFound() {
        // Arrange
        Long negativeId = -1L;
        when(biciService.getById(negativeId)).thenReturn(null);

        // Act
        ResponseEntity<BiciDto> response = biciController.getById(negativeId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(biciService, times(1)).getById(negativeId);
    }
}
