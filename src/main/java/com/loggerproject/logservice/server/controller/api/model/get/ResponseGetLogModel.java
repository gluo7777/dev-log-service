package com.loggerproject.logservice.server.controller.api.model.get;

import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.microserviceglobalresource.pojo.controller.response.sub.ResponseGetModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseGetLogModel extends ResponseGetModel {
    List<LogModel> logModels;
}
