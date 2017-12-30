package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    public List<LogModel> get(RequestGetLogModel request) {
        LogModel[] logModels = restTemplate.postForObject("http://LOG-SERVICE/api/get", request, LogModel[].class);
        return Arrays.asList(logModels);
    }
}
