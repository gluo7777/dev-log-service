package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.controller.api.model.create.RequestCreateLogModels;
import com.loggerproject.logservice.server.controller.api.model.create.ResponseCreateLogModels;
import com.loggerproject.logservice.server.controller.api.model.delete.RequestDeleteLogModels;
import com.loggerproject.logservice.server.controller.api.model.delete.ResponseDeleteLogModels;
import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModels;
import com.loggerproject.logservice.server.controller.api.model.get.ResponseGetLogModels;
import com.loggerproject.logservice.server.controller.api.model.update.RequestUpdateLogModels;
import com.loggerproject.logservice.server.controller.api.model.update.ResponseUpdateLogModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    private static final String END_POINT = "http://LOG-SERVICE";

    public ResponseCreateLogModels create(RequestCreateLogModels request) {
        return restTemplate.postForObject(END_POINT + "/api/create", request, ResponseCreateLogModels.class);
    }

    public ResponseUpdateLogModels update(RequestUpdateLogModels request) {
        return restTemplate.postForObject(END_POINT + "/api/update", request, ResponseUpdateLogModels.class);
    }

    public ResponseGetLogModels get(RequestGetLogModels request) {
        return restTemplate.postForObject(END_POINT + "/api/get", request, ResponseGetLogModels.class);
    }

    public ResponseDeleteLogModels delete(RequestDeleteLogModels request) {
        return restTemplate.postForObject(END_POINT + "/api/delete", request, ResponseDeleteLogModels.class);
    }
}
