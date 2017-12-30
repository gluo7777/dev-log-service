package com.loggerproject.logservice.controller.api.model.update;

import com.loggerproject.globalresource.pojo.controller.response.sub.success.sub.ResponseSuccessUpdateModel;
import com.loggerproject.logservice.data.model.LogModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSuccessUpdateLogModel extends ResponseSuccessUpdateModel {
    List<LogModel> updatedLogModels;
}
