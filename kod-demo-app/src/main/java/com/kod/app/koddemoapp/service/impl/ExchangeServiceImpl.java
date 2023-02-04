package com.kod.app.koddemoapp.service.impl;

import com.kod.app.koddemoapp.entity.ExchangeEntity;
import com.kod.app.koddemoapp.repository.ExchangeRepository;
import com.kod.app.koddemoapp.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Optional<ExchangeEntity> getExchangeById(Long id) {
        return exchangeRepository.findById(id);
    }

    @Override
    public List<ExchangeEntity> getAllExchange() {
        return exchangeRepository.findAll();
    }

    @Override
    public ExchangeEntity saveExchange(ExchangeEntity exchangeEntity) {
        return exchangeRepository.save(exchangeEntity);
    }

    @Override
    public void deleteExchange(Long id) {
        getExchangeById(id).ifPresent(entity -> exchangeRepository.delete(entity));
    }
}
