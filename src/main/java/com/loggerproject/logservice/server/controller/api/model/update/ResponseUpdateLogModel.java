package com.loggerproject.logservice.server.controller.api.model.update;

import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.microserviceglobalresource.pojo.controller.response.sub.ResponseUpdateModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseUpdateLogModel extends ResponseUpdateModel {
    List<LogModel> updatedModels;
}
