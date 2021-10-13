package com.example.gifrate;

import com.example.gifrate.clients.GifFeignClient;
import com.example.gifrate.clients.RateFeignClient;
import com.example.gifrate.controllers.RateController;
import com.example.gifrate.models.GifModel;
import com.example.gifrate.models.RateModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GifRateApplicationTests {
	@MockBean
	private RateFeignClient rateFeignClient;

	@MockBean
	private GifFeignClient gifFeignClient;

	@MockBean
	private RateController rateController;

	@Test
	void rateFeignClientTest() {
		Mockito.doReturn(new RateModel())
				.when(rateFeignClient)
				.getTodayRate(Mockito.any());
	}

	@Test
	void gifFeignClient(){
		Mockito.doReturn(new GifModel())
				.when(gifFeignClient)
				.getGif(Mockito.any());
	}

	@Test
	void rateControllerTest(){
		Mockito.doReturn(new GifModel())
				.when(rateController)
				.rate();

	}

}
