package com.biciman.go.persistence.crud;

import com.biciman.go.persistence.entity.Bicicleta;
import org.springframework.data.repository.CrudRepository;

public interface CrudBiciclyEntiy extends CrudRepository<Bicicleta, Long> {

    Bicicleta findFirstBymarca(String marca);
}
