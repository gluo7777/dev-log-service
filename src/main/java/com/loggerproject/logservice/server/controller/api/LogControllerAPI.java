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
public class LogControllerAPI {

	@Autowired
	LogService logService;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseModel create(@RequestBody RequestCreateLogModel request) {
		ResponseCreateLogModel response = new ResponseCreateLogModel();

		try {
			List<LogModel> createdModels = request.getModels().stream().map(model -> logService.create(model)).collect(Collectors.toList());
			response.setCreatedModels(createdModels);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setSuccess(false);
		}

		return response;
	}

	@PostMapping(value = "/update", produces = "application/json")
	public ResponseModel update(@RequestBody RequestUpdateLogModel request) {
		ResponseUpdateLogModel response = new ResponseUpdateLogModel();
		
		try {
			List<LogModel> updatedModels = request.getModels().stream().map(model -> logService.update(model)).collect(Collectors.toList());
			response.setUpdatedModels(updatedModels);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setSuccess(false);
		}

		return response;
	}

	@PostMapping(value = "/get", produces = "application/json")
	public ResponseModel get(@RequestBody RequestGetLogModel request) {
		ResponseGetLogModel response = new ResponseGetLogModel();

		try {
			List<LogModel> models = request.getIds().stream().map(modelID -> logService.getFindOne(modelID)).collect(Collectors.toList());
			response.setModels(models);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setSuccess(false);
		}

		return response;
	}

	@PostMapping(value = "/delete", produces = "application/json")
	public ResponseModel delete(@RequestBody RequestDeleteLogModel request) {
		ResponseDeleteLogModel response = new ResponseDeleteLogModel();

		try {
			List<LogModel> deletedModels = request.getIds().stream().map(modelID -> logService.delete(modelID)).collect(Collectors.toList());
			response.setDeletedModels(deletedModels);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setSuccess(false);
		}

		return response;
	}
}
