package com.loggerproject.logservice.server.controller.api.model.create;

import com.loggerproject.microserviceglobalresource.pojo.controller.request.sub.RequestCreateModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestCreateLogModels extends RequestCreateModel {
    List<LogModel> models;
}
