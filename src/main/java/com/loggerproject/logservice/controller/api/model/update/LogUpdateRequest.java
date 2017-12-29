package com.loggerproject.logservice.controller.api.model.update;

import lombok.Data;

import java.util.List;

@Data
public class LogUpdateRequest {

    List<String> paths;
    List<String> tags;
}
