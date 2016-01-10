package utilities;

/**
 * This class contains the configuration accessor for the application.
 */
public final class Configuration {
    private static final String CONFIGURATION_FILE = "app.properties";

    private static Configuration instance = new Configuration();

    private static java.util.Properties properties;

    private Configuration() {
        properties = new java.util.Properties();

        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE));
        } catch(Exception ignored) {}
    }

    public static Configuration getInstance() {
        return instance;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public enum Properties {
        DB_DRIVER("db.driver"),
        DB_URL("db.url"),
        DB_USER("db.user"),
        DB_PASSWORD("db.password");

        private final String name;

        private Properties(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
