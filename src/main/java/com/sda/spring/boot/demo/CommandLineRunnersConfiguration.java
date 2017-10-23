package com.sda.spring.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class CommandLineRunnersConfiguration {

    @Autowired
    CurrencyRatioUpdaterService currencyRatioUpdaterService;

    @Bean
    CommandLineRunner addInitalDataToDB(CurrencyRatioRepository currencyRatioRepository) {
        return strings -> {
            Arrays.asList("PLN,EUR,4.2","PLN,USD,3.9", "USD,EUR,1.2").stream()
                    .forEach(values -> {
                        String[] splitted = values.split(",");
                        currencyRatioRepository.save(new CurrencyRatio(splitted[0],splitted[1], LocalDateTime.now(),new BigDecimal(splitted[2])));
                    });

            currencyRatioRepository.findAll().stream().forEach(System.out::println);


        };
    }

    @Bean
    CommandLineRunner fetchExternalData(CurrencyRatioRepository currencyRatioRepository){
        return (args) -> {

            while(true) {
                JsonExternalRestResponse response = currencyRatioUpdaterService.getResponse("USD");
                CurrencyRatio currencyRatio = new CurrencyRatio(response.getBase(),"CZK",LocalDateTime.now(),new BigDecimal(response.getRates().get("CZK")));
                currencyRatioRepository.save(currencyRatio);
                Thread.sleep(10000);
            }
        };
    }

}
