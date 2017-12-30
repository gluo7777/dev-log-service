package com.loggerproject.logservice.controller.api.model.create;

import com.loggerproject.globalresource.pojo.controller.response.sub.success.sub.ResponseSuccessCreateModel;
import com.loggerproject.logservice.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessCreateLogModel extends ResponseSuccessCreateModel {
    List<LogModel> createdLogModel;
}
