package com.loggerproject.logservice.server.controller.api.model.get;

import com.loggerproject.microserviceglobalresource.pojo.controller.request.sub.RequestGetModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestGetLogModel extends RequestGetModel {
    List<String> logIDs;
}
