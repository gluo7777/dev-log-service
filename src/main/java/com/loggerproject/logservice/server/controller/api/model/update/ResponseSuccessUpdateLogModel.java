package com.loggerproject.logservice.server.controller.api.model.update;

import com.loggerproject.globalresource.pojo.controller.response.sub.success.sub.ResponseSuccessUpdateModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessUpdateLogModel extends ResponseSuccessUpdateModel {
    List<LogModel> updatedLogModels;
}
