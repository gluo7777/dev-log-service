package com.loggerproject.logservice.controller.api.model.get;

import com.loggerproject.globalresource.pojo.controller.request.sub.RequestGetModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestGetLogModel extends RequestGetModel {
    List<String> logIDs;
}
