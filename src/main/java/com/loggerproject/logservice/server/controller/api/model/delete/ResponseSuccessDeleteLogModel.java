package com.loggerproject.logservice.controller.api.model.delete;

import com.loggerproject.globalresource.pojo.controller.response.sub.success.sub.ResponseSuccessDeleteModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessDeleteLogModel extends ResponseSuccessDeleteModel {
    List<LogModel> deletedLogModels;
}
