package com.loggerproject.logservice.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "log")
public class LogModel {
    @Id
    String id;
    List<String> directoryIDs;
    List<String> tagIDs;
}
