package com.loggerproject.logservice.service;

import com.loggerproject.logservice.data.model.LogModel;
import com.loggerproject.logservice.data.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    public LogModel create(LogModel logModel) {
        logModel.setId(null);
        logModel.setDirectoryIDs(logModel.getDirectoryIDs() == null ? new ArrayList<>() : logModel.getDirectoryIDs());
        logModel.setTagIDs(logModel.getTagIDs()  == null ? new ArrayList<>() : logModel.getTagIDs());

        logRepository.save(logModel);

        return logModel;
    }

    public LogModel update(LogModel model) {
        LogModel logModel = logRepository.findOne(model.getId());

        logModel.setDirectoryIDs(logModel.getDirectoryIDs() == null ? new ArrayList<>() : logModel.getDirectoryIDs());
        logModel.setTagIDs(logModel.getTagIDs()  == null ? new ArrayList<>() : logModel.getTagIDs());

        logRepository.save(logModel);

        return logModel;
    }

    public LogModel getFindOne(String logID) {
        return logRepository.findOne(logID);
    }

    public LogModel delete(String logID) {
        LogModel logmodel = getFindOne(logID);
    	logRepository.delete(logID);

        return logmodel;
    }
}



