package com.loggerproject.logservice.server.controller.api.model.update;

import com.loggerproject.microserviceglobalresource.pojo.controller.request.sub.RequestUpdateModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestUpdateLogModel extends RequestUpdateModel {
    List<LogModel> logModels;
}
