package com.loggerproject.logservice.server.controller.api;

import com.loggerproject.globalresource.pojo.controller.response.ResponseModel;
import com.loggerproject.logservice.server.controller.api.model.create.RequestCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.create.ResponseErrorCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.create.ResponseSuccessCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.RequestDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.ResponseErrorDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.ResponseSuccessDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.ResponseSuccessGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.RequestUpdateLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.ResponseErrorUpdateLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.ResponseSuccessUpdateLogModel;
import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.logservice.server.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class LogController {

	@Autowired
	LogService logService;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseModel createLogs(@RequestBody RequestCreateLogModel request) {
		try {
			List<LogModel> createdLogModels = request.getLogModels().stream().map(logModel -> logService.create(logModel)).collect(Collectors.toList());

			ResponseSuccessCreateLogModel successResponse = new ResponseSuccessCreateLogModel();
			successResponse.setCreatedLogModel(createdLogModels);
			return successResponse;
		} catch (Exception e) {
			ResponseErrorCreateLogModel errorResponse = new ResponseErrorCreateLogModel();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}

	@PostMapping(value = "/update", produces = "application/json")
	public ResponseModel updateLogs(@RequestBody RequestUpdateLogModel request) {
		try {
			List<LogModel> updatedLogModels = request.getLogModels().stream().map(logModel -> logService.update(logModel)).collect(Collectors.toList());

			ResponseSuccessUpdateLogModel successResponse = new ResponseSuccessUpdateLogModel();
			successResponse.setUpdatedLogModels(updatedLogModels);
			return successResponse;
		} catch (Exception e) {
			ResponseErrorUpdateLogModel errorResponse = new ResponseErrorUpdateLogModel();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}

	@PostMapping(value = "/get", produces = "application/json")
	public ResponseModel getLogs(@RequestBody RequestGetLogModel request) {
		try {
			List<LogModel> logModels = request.getLogIDs().stream().map(logModelID -> logService.getFindOne(logModelID)).collect(Collectors.toList());

			ResponseSuccessGetLogModel successResponse = new ResponseSuccessGetLogModel();
			successResponse.setLogModels(logModels);
			return successResponse;
		} catch (Exception e) {
			ResponseErrorUpdateLogModel errorResponse = new ResponseErrorUpdateLogModel();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}

	@PostMapping(value = "/delete", produces = "application/json")
	public ResponseModel deleteLogs(@RequestBody RequestDeleteLogModel request) {
		try {
			List<LogModel> deletedLogModels = request.getLogIDs().stream().map(logModelID -> logService.delete(logModelID)).collect(Collectors.toList());

			ResponseSuccessDeleteLogModel successResponse = new ResponseSuccessDeleteLogModel();
			successResponse.setDeletedLogModels(deletedLogModels);
			return successResponse;
		} catch (Exception e) {
			ResponseErrorDeleteLogModel errorResponse = new ResponseErrorDeleteLogModel();
			errorResponse.setErrorMessage(e.getMessage());
			return errorResponse;
		}
	}
}
