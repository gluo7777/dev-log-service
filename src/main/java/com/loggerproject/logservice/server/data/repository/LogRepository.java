package com.loggerproject.logservice.server.data.repository;

import com.loggerproject.logservice.server.data.model.LogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogModel, String> {
}
