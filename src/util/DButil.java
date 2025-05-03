package util;

import java.io.InputStream;
import java.util.Properties;

public class DButil {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream input = DButil.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
