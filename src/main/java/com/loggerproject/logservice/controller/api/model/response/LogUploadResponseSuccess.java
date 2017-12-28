package com.loggerproject.logservice.controller.api.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class LogUploadResponseSuccess extends Response {
    String logID;
}
