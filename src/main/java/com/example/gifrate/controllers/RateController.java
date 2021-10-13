package com.example.gifrate.controllers;

import com.example.gifrate.clients.GifFeignClient;
import com.example.gifrate.clients.RateFeignClient;
import com.example.gifrate.models.GifModel;
import com.example.gifrate.models.RateModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RateController {

    final RateFeignClient rateClient;

    final GifFeignClient gifFeignClient;

    @Value("${APP_ID}")
    String APP_ID;

    LocalDate today = LocalDate.now();
    LocalDate yesterday = today.minus(Period.ofDays(1));

    public RateController(RateFeignClient rateClient, GifFeignClient gifFeignClient) {
        this.rateClient = rateClient;
        this.gifFeignClient = gifFeignClient;
    }

    @GetMapping(value = "/rate")
    public GifModel rate() {
        RateModel todayRate = rateClient.getTodayRate(today.toString());
        RateModel yesterdayRate = rateClient.getTodayRate(yesterday.toString());
        return todayRate.getRates().get("RUB") > yesterdayRate.getRates().get("RUB") ? gifFeignClient.getGif("rich") : gifFeignClient.getGif("broke");
    }

}
