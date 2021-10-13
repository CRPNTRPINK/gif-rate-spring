package com.example.gifrate.clients;

import com.example.gifrate.models.GifModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gif", url = "${URI_GIF}")
public interface GifFeignClient {

    @GetMapping(value = "?api_key=${API_KEY}&tag={tag}")
    GifModel getGif(@PathVariable String tag);
}
