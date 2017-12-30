package com.loggerproject.logservice.controller.api.model.delete;

import com.loggerproject.globalresource.pojo.controller.request.sub.RequestDeleteModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestDeleteLogModel extends RequestDeleteModel {
    List<String> logIDs;
}
