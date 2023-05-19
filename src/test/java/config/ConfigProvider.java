package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigProvider {

    static Config getEnvConfig() {
        if (System.getProperty("env").equals("dev")) {
            return ConfigFactory.load("dev_config.conf");
        } else if (System.getProperty("env").equals("prod")) {
            return ConfigFactory.load("prod_config.conf");
        }
        throw new RuntimeException("environment is not exists");
    }

    static Config getBrowserConfig() {
        return ConfigFactory.load("browser_config.conf");
    }

}
