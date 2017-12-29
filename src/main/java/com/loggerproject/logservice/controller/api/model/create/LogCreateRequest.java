package com.loggerproject.logservice.controller.api.model.create;

import lombok.Data;

import java.util.List;

@Data
public class LogCreateRequest {

    List<String> paths;
    List<String> tags;
}
