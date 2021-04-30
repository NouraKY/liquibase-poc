package com.elm.liquibase.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadVault {

    InputStream inputStream;
    public String getPropValues() throws IOException {


        Properties prop = new Properties();
        String propFileName = "bootstrap.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null){
            prop.load(inputStream);
        }else{
            throw new FileNotFoundException("property file '"+ propFileName+ "'not found in the class path");
        }

        String appName = prop.getProperty("spring.cloud.vault.token");
        return appName;

        //System.out.println("Testing app= "+ );

    }
}
