package com.kod.app.koddemoapp.service;

import com.kod.app.koddemoapp.entity.ExchangeEntity;

import java.util.List;
import java.util.Optional;

public interface ExchangeService {
    Optional<ExchangeEntity> getExchangeById(Long id);
    List<ExchangeEntity> getAllExchange();
    ExchangeEntity saveExchange(ExchangeEntity exchangeEntity);
    void deleteExchange(Long id);
}
