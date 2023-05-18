package config;

import com.typesafe.config.Config;

public class ReadConfig {
    private static final Config config = ConfigProvider.getConfig();

    public static String getBaseUrl() {
        return config.getString("baseUrl");
    }
    public static String getLogin(){
        return config.getString("authData.user.login");
    }
    public static String getPassword(){
        return config.getString("authData.user.password");
    }
}
