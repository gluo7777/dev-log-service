package com.loggerproject.logservice.controller.api.model.create;

import com.loggerproject.logservice.controller.api.model.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class LogCreateResponseError extends Response {

    Boolean success;
    String errorMessage;
}
