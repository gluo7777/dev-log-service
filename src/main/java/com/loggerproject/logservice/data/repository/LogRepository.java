package com.loggerproject.logservice.data.repository;

import com.loggerproject.logservice.data.model.LogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogModel, String> {
}
