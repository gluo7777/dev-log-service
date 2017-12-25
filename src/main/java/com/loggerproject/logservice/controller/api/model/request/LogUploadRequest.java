package com.loggerproject.logservice.controller.api.model.request;

import lombok.Data;

import java.util.List;

@Data
public class LogUploadRequest {

    List<String> paths;
    List<String> tags;
}
