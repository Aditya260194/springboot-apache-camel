package com.study.apachecamel.routeconfig;

import com.study.apachecamel.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileRouteConfig extends RouteBuilder {

    private String source="C:/Users/adity/Stuff/Study/intellij workspace/springboot-apache-camel/source";
    private String destination="C:/Users/adity/Stuff/Study/intellij workspace/springboot-apache-camel/destination";

    @Autowired
    FileProcessor fileProcessor;

    @Override
    public void configure() throws Exception {
        from("file://"+source)
                .routeId("simple-file-route")
                .log("File picked")
                .process(fileProcessor)
                .to("file://"+destination)
                .log("File moved");
    }
}
