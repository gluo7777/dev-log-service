package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.ResponseGetLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    public ResponseGetLogModel get(RequestGetLogModel request) {
        return restTemplate.postForObject("http://LOG-SERVICE/api/get", request, ResponseGetLogModel.class);
    }
}
