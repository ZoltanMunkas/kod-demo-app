package com.kod.app.koddemoapp.service.impl;

import com.kod.app.koddemoapp.entity.CurrencyEntity;
import com.kod.app.koddemoapp.repository.CurrencyRepository;
import com.kod.app.koddemoapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Optional<CurrencyEntity> getCurrencyById(Long id) {
        return currencyRepository.findById(id);
    }

    @Override
    public List<CurrencyEntity> getAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public CurrencyEntity saveCurrency(CurrencyEntity currencyEntity) {
        return currencyRepository.save(currencyEntity);
    }

    @Override
    public void deleteCurrency(Long id) {
        getCurrencyById(id).ifPresent(entity -> currencyRepository.delete(entity));
    }
}
