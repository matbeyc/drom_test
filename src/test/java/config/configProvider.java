package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class configProvider {
    Config config;

    static Config readConfig(){
        return ConfigFactory.load();

    }
}
