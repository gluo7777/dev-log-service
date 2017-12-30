package com.loggerproject.logservice.controller.api.model.create;

import com.loggerproject.globalresource.pojo.controller.request.sub.RequestCreateModel;
import com.loggerproject.logservice.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestCreateLogModel extends RequestCreateModel {
    List<LogModel> logModels;
}
