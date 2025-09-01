package org.example;

public class AppConfig {

    public static String get(String key) {
        return System.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        return (value != null) ? value : defaultValue;
    }

    // Métodos específicos para facilitar o uso
    public static String getAppName() {
        return get("APP_NAME", "MinhaAplicacao");
    }

    public static String getAppEnv() {
        return get("APP_ENV", "dev");
    }

    public static String getAppVersion() {
        return get("APP_VERSION", "1.0.0");
    }

}
