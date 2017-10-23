package com.sda.spring.boot.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class CurrencyRatio {

    @Id
    @GeneratedValue
    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private LocalDateTime dateOfCheck;
    private BigDecimal ratio;

    public CurrencyRatio() {
    }

    public CurrencyRatio(String currencyFrom, String currencyTo, LocalDateTime dateOfCheck, BigDecimal ratio) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.dateOfCheck = dateOfCheck;
        this.ratio = ratio;
    }

    public Long getId() {
        return id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public LocalDateTime getDateOfCheck() {
        return dateOfCheck;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "CurrencyRatio{" +
                "id=" + id +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", dateOfCheck=" + dateOfCheck +
                ", ratio=" + ratio +
                '}';
    }
}
