package config;

import com.typesafe.config.Config;

public class ReadBrowserConfig {
    private static final Config config = ConfigProvider.getBrowserConfig();

    public static Integer getImplicitlyWaits() {
        return config.getInt("implicitlyWait");
    }

    public static Integer getExpectedWait() {
        return config.getInt("expectedWait");
    }

    public static Integer getPageLoadTimeout() {
        return config.getInt("pageLoadTimeout");
    }

    public static String getWebBrowser() {
        return config.getString("webBrowser");
    }

    public static String getMobileBrowser() {
        return config.getString("mobileBrowser");
    }
}
