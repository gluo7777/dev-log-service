package com.loggerproject.logservice.controller.api.model.response;

import lombok.Data;

@Data
public class LogUploadResponseError extends Response{

    Boolean success;
    String errorMessage;
}
