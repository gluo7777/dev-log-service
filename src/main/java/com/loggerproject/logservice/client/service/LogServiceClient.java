package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.data.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    public LogModel getLogModel(String logID) {
        return this.restTemplate.getForObject("http://LOG-SERVICE/api/get/" + logID, LogModel.class);
    }
}
