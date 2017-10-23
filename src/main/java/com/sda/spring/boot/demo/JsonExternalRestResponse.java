package com.sda.spring.boot.demo;

import java.util.Map;

public class JsonExternalRestResponse {

    private String base;
    private Map<String, String> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "JsonExternalRestResponse{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
