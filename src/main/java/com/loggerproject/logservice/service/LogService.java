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

    public LogModel findOne(String logID) {
        return logRepository.findOne(logID);
    }

    /**
     * 
     * @param paths
     * @param tags
     * @return id of log model created
     */
    public String create(List<String> paths, List<String> tags) {
        LogModel logModel = new LogModel();

        paths = paths == null ? new ArrayList<>() : paths;
        tags  = tags  == null ? new ArrayList<>() : tags;

        logModel.setPathIDs(paths);
        logModel.setTagIDs(tags);

        logRepository.save(logModel);

        return logModel.getId();
    }
    
    public void delete(String id) {
    	logRepository.delete(id);
    }
    
    public LogModel update(LogModel model) {
    	LogModel old = logRepository.findOne(model.getId());
    	old.setPathIDs(model.getPathIDs());
    	old.setTagIDs(model.getTagIDs());
    	logRepository.save(old);
    	return old;
    }
}



