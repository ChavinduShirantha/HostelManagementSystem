package lk.ijse.hibernate.d24.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:22 AM
 **/
public class Utility {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader
                    .getSystemClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }
}
