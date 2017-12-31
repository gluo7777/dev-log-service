package com.loggerproject.logservice.server.controller.api.model.delete;

import com.loggerproject.microserviceglobalresource.pojo.controller.request.sub.RequestDeleteModel;
import lombok.Data;

import java.util.List;

@Data
public class RequestDeleteLogModels extends RequestDeleteModel {
    List<String> ids;
}
