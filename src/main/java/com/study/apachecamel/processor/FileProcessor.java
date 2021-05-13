package com.study.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("File Processor message : " + exchange.getMessage().getBody().toString());
        //read file and update data
        GenericFile file = (GenericFile) exchange.getMessage().getBody();
        File f =(File) file.getBody();
        String content = FileUtils.readFileToString(f , "UTF-8");
        System.out.println("Content - " + content);
        content = content + " Been through FileProcessor";
        FileUtils.writeStringToFile(f, content, "UTF-8");
        file.setBody(f);
        exchange.getMessage().setBody(file);
    }
}
