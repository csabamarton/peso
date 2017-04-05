package com.csmarton.rest;

import com.google.common.collect.ImmutableMap;

import com.csmarton.model.ChangeRequest;
import com.csmarton.model.ChangeResult;
import com.csmarton.service.CashRegisterFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChangeEndpointsTest {

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper objectMapper;
    HttpHeaders headers;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void requestShouldReturnWithTestResponseString() {
        String body = this.restTemplate.getForObject("/api/test", String.class);
        assertThat(body).isEqualTo("It works");
    }

    @Test
    public void cucCurrencyShouldReturnWithBanknotesAndRemains() throws IOException, JSONException {
        String s = getChangeRequestAsJsonString(CashRegisterFactory.CUC + "df", 248);

        HttpEntity<String> entity = new HttpEntity<>(s, headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("/api/get/banknotes", entity, String.class);

        ChangeResult changeResult = objectMapper.readValue(stringResponseEntity.getBody(), ChangeResult.class);

        assertThat(changeResult).isNotNull();

        Map<Integer, Integer> cucReturnMap = ImmutableMap.<Integer, Integer>builder()
                .put(100, 1)
                .put(50, 2)
                .put(20, 1)
                .put(10, 1)
                .put(5, 1)
                .put(3, 1)
                .put(1, 1)
                .build();

        assertThat(changeResult.getUsedBanknotesMap()).isEqualTo(cucReturnMap);

        stringResponseEntity = restTemplate.postForEntity("/api/get/banknotes", entity, String.class);

        changeResult = objectMapper.readValue(stringResponseEntity.getBody(), ChangeResult.class);

        assertThat(changeResult).isNotNull();



    }

    private String getChangeRequestAsJsonString(String registerKey, int value) throws JsonProcessingException {
        ChangeRequest request = new ChangeRequest(registerKey, value);

        return objectMapper.writeValueAsString(request);
    }

    @Test
    public void getCashRegisterInventoryShouldReturnWithBanknotes() {
        String responseEntity = this.restTemplate.getForObject("/api/get/inventory", String.class);
        assertThat("").isEqualTo("It works");
    }


}