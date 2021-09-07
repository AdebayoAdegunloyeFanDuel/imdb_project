package config_mgr;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigMgr {
    private static final Properties config;

    static {
        config = new Properties();
        try {
            config.load(new FileReader("src/main/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String imdbFileLocation(){
        return config.getProperty("imdbFileLocation");
    }
}
