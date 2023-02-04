package com.kod.app.koddemoapp.service;

import com.kod.app.koddemoapp.entity.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    Optional<CurrencyEntity> getCurrencyById(Long id);
    List<CurrencyEntity> getAllCurrency();
    CurrencyEntity saveCurrency(CurrencyEntity currencyEntity);
    void deleteCurrency(Long id);
}
