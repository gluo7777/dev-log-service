package com.loggerproject.logservice.client;

import com.loggerproject.logservice.client.configuration.LogServiceClientConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(LogServiceClientConfiguration.class)
public @interface EnableLogServiceClient {
}
