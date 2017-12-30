package com.loggerproject.logservice.server.controller.api.model.create;

import com.loggerproject.microserviceglobalresource.pojo.controller.response.sub.success.sub.ResponseSuccessCreateModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessCreateLogModel extends ResponseSuccessCreateModel {
    List<LogModel> createdLogModel;
}
