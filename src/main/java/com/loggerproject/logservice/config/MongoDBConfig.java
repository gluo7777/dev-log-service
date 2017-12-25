package com.loggerproject.logservice.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoDBConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(host, port), database);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(
                mongoDbFactory(),
                mongoConverter());

        return mongoTemplate;
    }

    @Bean
    public MappingMongoConverter mongoConverter() throws Exception {
        //remove _class
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mongoConverter;
    }
}
