package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    public List<LogModel> get(RequestGetLogModel request) {
        ParameterizedTypeReference<List<LogModel>> typeRef = new ParameterizedTypeReference<List<LogModel>>() {};
        ResponseEntity<List<LogModel>> responseEntity = restTemplate.exchange("http://LOG-SERVICE/api/get", HttpMethod.POST, new HttpEntity<>(request), typeRef);
        return responseEntity.getBody();
    }
}
