package com.sda.spring.boot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrentRatioMvcController {

    private final CurrencyRatioRepository currencyRatioRepository;

    public CurrentRatioMvcController(CurrencyRatioRepository currencyRatioRepository) {
        this.currencyRatioRepository = currencyRatioRepository;
    }

    @RequestMapping("/currentCurrencyRatios")
    String currentRatios(Model model) {
        model.addAttribute("currentRatios", this.currencyRatioRepository.findAll());
        return "currentRatiosSite";
    }
}

