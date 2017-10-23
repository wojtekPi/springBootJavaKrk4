package com.sda.spring.boot.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@RepositoryRestResource
public interface CurrencyRatioRepository extends JpaRepository<CurrencyRatio,Long> {
    Collection<CurrencyRatio> findAllByCurrencyFromAndCurrencyToOrderByDateOfCheck(String currencyFrom, String currencyTo);
}
