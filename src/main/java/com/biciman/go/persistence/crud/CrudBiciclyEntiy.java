package com.biciman.go.persistence.crud;

import com.biciman.go.persistence.entity.BiciEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBiciclyEntiy extends CrudRepository<BiciEntity, Long> {
}
