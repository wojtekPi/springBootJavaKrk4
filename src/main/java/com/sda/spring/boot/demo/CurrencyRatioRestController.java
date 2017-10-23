package com.sda.spring.boot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CurrencyRatioRestController {


    private final CurrencyRatioRepository currencyRatioRepository;

    public CurrencyRatioRestController(CurrencyRatioRepository currencyRatioRepository) {
        this.currencyRatioRepository = currencyRatioRepository;
    }

    @RequestMapping(value = "/currencies")
    public Collection<CurrencyRatio> getAllRecords() {
        return currencyRatioRepository.findAll();
    }
}
