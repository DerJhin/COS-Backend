package com.cos.capybara.RandomOrg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RandomOrgService {

    private final RestTemplate restTemplate;

    public RandomOrgService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //TODO@JSE: Try binding these together so there are less requests to the API
    public double generateDecimalFractionsForRandomSkin() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 1);
        params.put("decimalPlaces", 5);
        params.put("replacement", true);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", "generateDecimalFractions");
        requestBody.put("params", params);
        requestBody.put("id", 42);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        Map responseBody = responseEntity.getBody();

        System.out.println("Response Body: " + responseBody);

        if (responseBody != null && responseBody.containsKey("result")) {
            Map result = (Map) responseBody.get("result");
            if (result.containsKey("random")) {
                Map random = (Map) result.get("random");
                if (random.containsKey("data")) {
                    System.out.println("Random Data: " + ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue());
                    return ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue();
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }

    public double generateDecimalFractionsForFloatSkin() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 1);
        params.put("decimalPlaces", 5);
        params.put("replacement", true);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", "generateDecimalFractions");
        requestBody.put("params", params);
        requestBody.put("id", 42);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        Map responseBody = responseEntity.getBody();

        System.out.println("Response Body: " + responseBody);

        if (responseBody != null && responseBody.containsKey("result")) {
            Map result = (Map) responseBody.get("result");
            if (result.containsKey("random")) {
                Map random = (Map) result.get("random");
                if (random.containsKey("data")) {
                    System.out.println("Random Data: " + ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue());
                    return ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue();
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }

    public int generateIntegersForStattrak() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 1);
        params.put("min", 1);
        params.put("max", 10);
        params.put("replacement", true);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", "generateIntegers");
        requestBody.put("params", params);
        requestBody.put("id", 42);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        Map responseBody = responseEntity.getBody();

        System.out.println("Response Body: " + responseBody);

        if (responseBody != null && responseBody.containsKey("result")) {
            Map result = (Map) responseBody.get("result");
            if (result.containsKey("random")) {
                Map random = (Map) result.get("random");
                if (random.containsKey("data")) {
                    System.out.println("Random Data: " + ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue());
                    return ((Number) ((ArrayList<?>) random.get("data")).get(0)).intValue();
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }

    public int generateIntegersForPattern() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 1);
        params.put("min", 1);
        params.put("max", 999);
        params.put("replacement", true);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", "generateIntegers");
        requestBody.put("params", params);
        requestBody.put("id", 42);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        Map responseBody = responseEntity.getBody();

        System.out.println("Response Body: " + responseBody);

        if (responseBody != null && responseBody.containsKey("result")) {
            Map result = (Map) responseBody.get("result");
            if (result.containsKey("random")) {
                Map random = (Map) result.get("random");
                if (random.containsKey("data")) {
                    System.out.println("Random Data: " + ((Number) ((ArrayList<?>) random.get("data")).get(0)).doubleValue());
                    return ((Number) ((ArrayList<?>) random.get("data")).get(0)).intValue();
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }
}
