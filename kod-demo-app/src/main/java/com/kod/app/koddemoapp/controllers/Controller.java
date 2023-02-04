package com.kod.app.koddemoapp.controllers;

import com.kod.app.koddemoapp.entity.CurrencyEntity;
import com.kod.app.koddemoapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    public String defaultMapping() {
        return "Demo backend up and running";
    }


    @GetMapping("/loadDummy") //using GET to make calling it from the browser easier
    public void loadDummyData() {
        currencyService.saveCurrency(CurrencyEntity.builder()
                .name("EUR")
                .build());
        currencyService.saveCurrency(CurrencyEntity.builder()
                .name("HUF")
                .build());
    }

    @GetMapping("/symbols")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CurrencyEntity> getSymbols() {
        return currencyService.getAllCurrency();
    }

    @PostMapping("/convert")
    @CrossOrigin(origins = "http://localhost:4200")
    public double convertFromTo(@RequestParam("from") Long from, @RequestParam("to") Long to, @RequestParam("amount") int amount) {
        return 500;
    }
}
