package com.boot.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.boot.App;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { App.class, ShipwreckController.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testListAll() throws JsonProcessingException, IOException {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/api/v1/shipwrecks",
				String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());

		assertThat(responseJson.isMissingNode(), is(false));
		assertThat(responseJson.toString(), startsWith("["));
		assertThat(responseJson.toString(), endsWith("]"));



	}

}
