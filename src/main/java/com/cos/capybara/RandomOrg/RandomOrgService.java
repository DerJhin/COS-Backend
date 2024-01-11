package com.cos.capybara.RandomOrg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RandomOrgService {

    private final RestTemplate restTemplate;

    public RandomOrgService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Generates a list of decimal fractions using the Random.org API.
     * The method makes a POST request to the Random.org API endpoint and retrieves the random decimal fractions.
     *
     * @return ArrayList<Double> - A list of random decimal fractions.
     * @throws RuntimeException if the API request fails or the response doesn't contain the required data.
     */
    //TODO@JSE: Try binding these together so there are less requests to the API
    public ArrayList<Double> generateDecimalFractions() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 2);
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
                    ArrayList<Double> randomData = new ArrayList<>();
                    ArrayList<?> dataList = (ArrayList<?>) random.get("data");
                    for (Object data : dataList) {
                        randomData.add(((Number) data).doubleValue());
                    }
                    return randomData;
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }

    public ArrayList<Integer> generateIntegers() {
        String url = "https://api.random.org/json-rpc/4/invoke";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("apiKey", "52ba3ac9-3c6e-42c0-911e-5fc4ff53d904");
        params.put("n", 2);
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
                    ArrayList<Integer> randomData = new ArrayList<>();
                    ArrayList<?> dataList = (ArrayList<?>) random.get("data");
                    for (Object data : dataList) {
                        randomData.add(((Number) data).intValue());
                    }
                    return randomData;
                }
            }
        }

        throw new RuntimeException("Failed to generate random integer");
    }
}
