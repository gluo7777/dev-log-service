package com.loggerproject.logservice.server.controller.api.model.create;

import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.microserviceglobalresource.pojo.controller.response.sub.ResponseCreateModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseCreateLogModel extends ResponseCreateModel {
    List<LogModel> createdLogModels;
}
