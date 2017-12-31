package com.loggerproject.logservice.client.service;

import com.loggerproject.logservice.server.controller.api.model.create.RequestCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.create.ResponseCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.RequestDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.ResponseDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.ResponseGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.RequestUpdateLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.ResponseUpdateLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogServiceClient {

    @Autowired
    RestTemplate restTemplate;

    public ResponseCreateLogModel create(RequestCreateLogModel request) {
        return restTemplate.postForObject("http://LOG-SERVICE/api/create", request, ResponseCreateLogModel.class);
    }

    public ResponseUpdateLogModel update(RequestUpdateLogModel request) {
        return restTemplate.postForObject("http://LOG-SERVICE/api/update", request, ResponseUpdateLogModel.class);
    }

    public ResponseGetLogModel get(RequestGetLogModel request) {
        return restTemplate.postForObject("http://LOG-SERVICE/api/get", request, ResponseGetLogModel.class);
    }

    public ResponseDeleteLogModel delete(RequestDeleteLogModel request) {
        return restTemplate.postForObject("http://LOG-SERVICE/api/delete", request, ResponseDeleteLogModel.class);
    }
}
