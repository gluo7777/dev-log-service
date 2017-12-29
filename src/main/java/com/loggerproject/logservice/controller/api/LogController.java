package com.loggerproject.logservice.controller.api;

import com.loggerproject.logservice.controller.api.model.create.LogCreateRequest;
import com.loggerproject.logservice.controller.api.model.create.LogCreateResponseError;
import com.loggerproject.logservice.controller.api.model.create.LogCreateResponseSuccess;
import com.loggerproject.logservice.controller.api.model.Response;
import com.loggerproject.logservice.controller.api.model.update.LogUpdateResponseError;
import com.loggerproject.logservice.controller.api.model.update.LogUpdateResponseSuccess;
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
	public LogModel getLog(@PathVariable(value = "logID") String logID) {
		return logService.findOne(logID);
	}

	@PostMapping(value = "/create", produces = "application/json")
	public Response createLog(@RequestBody LogCreateRequest request) {
		try {
			String logID = logService.create(request.getPaths(), request.getTags());

			LogCreateResponseSuccess successResponse = new LogCreateResponseSuccess();
			successResponse.setLogID(logID);
			return successResponse;
		} catch (Exception e) {
			LogCreateResponseError errorResponse = new LogCreateResponseError();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}

	@DeleteMapping(value = "/delete/{logID}")
	public void deleteLog(@PathVariable(value = "logID") String logID) {
		logService.delete(logID);
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Response updateLog(@RequestBody LogModel logModel) {
		try {
			String logId = logService.update(logModel).getId();

			LogUpdateResponseSuccess successResponse = new LogUpdateResponseSuccess();
			successResponse.setLogID(logId);
			return successResponse;
		} catch (Exception e) {
			LogUpdateResponseError errorResponse = new LogUpdateResponseError();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}
}
