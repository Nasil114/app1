package com.example.springboot;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/service1/app1", String.class);
        assertThat(response.getBody()).isEqualTo("This is a application1!");
    }

    @Test
    public void get() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/service1/getcurrentime", String.class);
        assertThat(response.getBody()).isNotNull();
    }
}
