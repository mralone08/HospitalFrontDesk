package com.cts;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class HospitalFrontDeskApplicationTests {

	@Test
	public void testGetSpecialistListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/hospital/apollo/cardiologist";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri,String.class);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
	}
}
