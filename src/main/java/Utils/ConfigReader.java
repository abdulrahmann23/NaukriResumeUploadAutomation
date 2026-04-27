package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	/*
	private static Properties properties;
	
	// Load the properties file
    public static void loadProperties() {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources folder!");
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }
	
	
	public static String getProperty(String key)
	{
		if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }
    */
	
	Properties prop;

    public ConfigReader() {
        try {
            FileInputStream file = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/config.properties"
            );

            prop = new Properties();
            prop.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getResumePath() {
        return prop.getProperty("resumePath");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
	}
	
	

