package com.elm.liquibase.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.bettercloud.vault.*;

public class liquibase{

    public static void main(String[] args) throws IOException, VaultException {

        ReadVault properties = new ReadVault();
        properties.getPropValues();
        System.out.println("Testing app in main class");

    }
}
