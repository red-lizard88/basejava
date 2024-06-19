package ru.javawebinar.basejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Config INSTANCE = new Config();
    public static Config get(){return INSTANCE;}

    private Properties props = new Properties();
    private Config(){
        try(InputStream is = new FileInputStream("./config/resumes.properties")){
            props.load(is);
            props.getProperty("");
        } catch (IOException e) {
           throw  new IllegalStateException("Invalid config  file");
        }

    }
}
