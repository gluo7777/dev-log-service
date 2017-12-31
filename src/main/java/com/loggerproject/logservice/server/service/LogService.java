package com.loggerproject.logservice.server.service;

import com.loggerproject.logservice.server.data.model.LogModel;
import com.loggerproject.logservice.server.data.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    private LogModel scrubModel(LogModel model) {
        model.setDirectoryIDs(model.getDirectoryIDs() == null ? new ArrayList<>() : model.getDirectoryIDs());
        model.setTagIDs(model.getTagIDs() == null ? new ArrayList<>() : model.getTagIDs());
        return model;
    }

    public LogModel create(LogModel model) {
        model = scrubModel(model);
        model.setId(null);
        logRepository.save(model);

        return model;
    }

    public LogModel update(LogModel model) {
        model = scrubModel(model);

        LogModel oldModel = logRepository.findOne(model.getId());
        if (oldModel != null) {
            oldModel.setDirectoryIDs(model.getDirectoryIDs());
            oldModel.setTagIDs(model.getTagIDs());
            logRepository.save(oldModel);
        }

        return oldModel;
    }

    public LogModel getFindOne(String id) {
        return logRepository.findOne(id);
    }

    public LogModel delete(String id) {
        LogModel model = getFindOne(id);
    	logRepository.delete(id);

        return model;
    }
}



