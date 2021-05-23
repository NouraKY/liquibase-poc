package com.elm.liquibase.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.bettercloud.vault.*;


public class ReadVault {

    static Logger logger = Logger.getLogger(String.valueOf(ReadVault.class));

    InputStream inputStream;
    public String getPropValues() throws IOException,VaultException {

        System.out.println("in ReadVault");

        Properties prop = new Properties();
        String propFileName = "bootstrap.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null){
            prop.load(inputStream);
        }else{
            throw new FileNotFoundException("property file '"+ propFileName+ "'not found in the class path");
        }

        String testVariable =System.getenv("VAULT_TOKEN");
        //System.out.println("test= "+ prop.getProperty("test"));
        System.out.println("using vault token= "+ System.getenv("VAULT_TOKEN"));
        System.out.println("using vault uri= "+ System.getenv("VAULT_URI"));


        //String vaulttoken = System.getenv("VAULT_TOKEN");
        //String vaulthost = System.getenv("VAULT_ADDR");

        final VaultConfig config = new VaultConfig().build();
        final Vault vault = new Vault(config);
        try {
            final String value = vault.logical()
                    .read("liquibase-poc/dev")
                    .getData().get("testConnection");
            System.out.format( "value key in liquibase-poc/dev is " + value +"\n");
            logger.info("vault value= "+ value);
        } catch(VaultException e) {
            System.out.println("Exception thrown: " + e);
        }


        return "test";


    }
}
