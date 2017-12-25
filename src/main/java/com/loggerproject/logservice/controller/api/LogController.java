package com.loggerproject.logservice.controller.api;

import com.loggerproject.logservice.controller.api.model.request.LogUploadRequest;
import com.loggerproject.logservice.controller.api.model.response.LogUploadResponseError;
import com.loggerproject.logservice.controller.api.model.response.LogUploadResponseSuccess;
import com.loggerproject.logservice.controller.api.model.response.Response;
import com.loggerproject.logservice.data.model.LogModel;
import com.loggerproject.logservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping(value = "/get/{logID}", produces = "application/json")
    public LogModel getLogModel(@PathVariable(value="logID") String logID) {
        return logService.findOne(logID);
    }

    @PostMapping(value = "/upload", produces = "application/json")
    public Response uploadImage(@RequestBody LogUploadRequest request) {
        try {
            String logID = logService.create(
                    request.getPaths(),
                    request.getTags()
            );

            LogUploadResponseSuccess successResponse = new LogUploadResponseSuccess();
            successResponse.setLogID(logID);
            return successResponse;
        }
        catch (Exception e) {
            LogUploadResponseError errorResponse = new LogUploadResponseError();
            errorResponse.setErrorMessage(e.getMessage());
            return errorResponse;
        }
    }
}
