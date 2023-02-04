package com.kod.app.koddemoapp.repository;

import com.kod.app.koddemoapp.entity.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}
