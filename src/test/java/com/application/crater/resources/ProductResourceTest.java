package com.application.crater.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class ProductResourceTest {

	@Value("${server.port}")
	private String serverPort = "8888";

	private String endpoint = "http://localhost:" + serverPort + "/produto";

	private CloseableHttpClient client;

	@InjectMocks
	private ProductResource resource;

	@BeforeAll
	public void setUp() {
		client = HttpClients.createDefault();
	}

	@AfterAll
	public void tearDown() throws IOException {
		client.close();
	}

	@Test
	public void givenValidRequest_createProduct_thenReturnResponse() throws ClientProtocolException, IOException {
		// arrange
		String name = "Notebook";
		Double price = 2400.99;
		Integer quantity = 12;
		String category = "Tecnologia";

		HttpPost httpPost = new HttpPost(endpoint);
		httpPost.setHeader("Content-type", "application/json");

		String json = String.format("{ \"name\": \"%s\", \"price\": %s, \"quantity\": %s, \"category\": \"%s\" }", name,
				price, quantity, category);
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);

		// act
		CloseableHttpResponse response = client.execute(httpPost);

		// assert
		assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
	}
}