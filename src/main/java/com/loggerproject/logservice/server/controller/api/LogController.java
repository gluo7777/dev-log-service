package com.loggerproject.logservice.server.controller.api;

import com.loggerproject.logservice.server.controller.api.model.get.ResponseGetLogModel;
import com.loggerproject.microserviceglobalresource.pojo.controller.response.ResponseModel;
import com.loggerproject.logservice.server.controller.api.model.create.RequestCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.create.ResponseCreateLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.RequestDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.delete.ResponseDeleteLogModel;
import com.loggerproject.logservice.server.controller.api.model.get.RequestGetLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.RequestUpdateLogModel;
import com.loggerproject.logservice.server.controller.api.model.update.ResponseUpdateLogModel;
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
		ResponseCreateLogModel response = new ResponseCreateLogModel();

		try {
			List<LogModel> createdLogModels = request.getLogModels().stream().map(logModel -> logService.create(logModel)).collect(Collectors.toList());
			response.setCreatedLogModels(createdLogModels);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;
	}

	@PostMapping(value = "/update", produces = "application/json")
	public ResponseModel updateLogs(@RequestBody RequestUpdateLogModel request) {
		ResponseUpdateLogModel response = new ResponseUpdateLogModel();
		
		try {
			List<LogModel> updatedLogModels = request.getLogModels().stream().map(logModel -> logService.update(logModel)).collect(Collectors.toList());
			response.setUpdatedLogModels(updatedLogModels);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;
	}

	@PostMapping(value = "/get", produces = "application/json")
	public ResponseModel getLogs(@RequestBody RequestGetLogModel request) {
		ResponseGetLogModel response = new ResponseGetLogModel();

		try {
			List<LogModel> logModels = request.getLogIDs().stream().map(logModelID -> logService.getFindOne(logModelID)).collect(Collectors.toList());
			response.setLogModels(logModels);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;
	}

	@PostMapping(value = "/delete", produces = "application/json")
	public ResponseModel deleteLogs(@RequestBody RequestDeleteLogModel request) {
		ResponseDeleteLogModel response = new ResponseDeleteLogModel();

		try {
			List<LogModel> deletedLogModels = request.getLogIDs().stream().map(logModelID -> logService.delete(logModelID)).collect(Collectors.toList());
			response.setDeletedLogModels(deletedLogModels);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;

	}
}
