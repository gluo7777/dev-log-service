package com.loggerproject.logservice.server.controller.api.model.delete;

import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.microserviceglobalresource.pojo.controller.response.sub.ResponseDeleteModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDeleteLogModel extends ResponseDeleteModel {
    List<LogModel> deletedModels;
}
