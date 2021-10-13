package com.example.gifrate.clients;

import com.example.gifrate.models.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rate", url = "${URI_RATE}")
public interface RateFeignClient {

    @GetMapping(value =  "{today}.json?app_id=${APP_ID}&symbols=${SYMBOL}")
    RateModel getTodayRate(@PathVariable String today);

}
