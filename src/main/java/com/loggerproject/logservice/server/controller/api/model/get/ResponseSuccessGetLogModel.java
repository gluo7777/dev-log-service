package com.loggerproject.logservice.server.controller.api.model.get;

import com.loggerproject.globalresource.pojo.controller.response.sub.success.sub.ResponseSuccessGetModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessGetLogModel extends ResponseSuccessGetModel {
    List<LogModel> logModels;
}
