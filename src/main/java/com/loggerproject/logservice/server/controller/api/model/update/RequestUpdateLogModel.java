package com.loggerproject.logservice.controller.api.model.update;

import com.loggerproject.globalresource.pojo.controller.request.sub.RequestUpdateModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestUpdateLogModel extends RequestUpdateModel {
    List<LogModel> logModels;
}
