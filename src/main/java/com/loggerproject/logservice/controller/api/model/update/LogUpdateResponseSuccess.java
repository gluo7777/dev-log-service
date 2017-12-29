package com.loggerproject.logservice.controller.api.model.update;

import com.loggerproject.logservice.controller.api.model.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class LogUpdateResponseSuccess extends Response {
    String logID;
}
