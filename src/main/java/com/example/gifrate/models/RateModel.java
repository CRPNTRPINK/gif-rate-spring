package com.example.gifrate.models;

import lombok.Data;

import java.util.Map;

@Data
public class RateModel {

    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;

}
