package com.donesvad.util;

import com.donesvad.enums.ConfigProperty;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
  private static final Properties properties = new Properties();

  static {
    String env = System.getProperty("environment", "test"); // Default to 'test'
    try (FileInputStream fis =
        new FileInputStream(
            "src"
                + File.separator
                + "test"
                + File.separator
                + "resources"
                + File.separator
                + "config"
                + File.separator
                + env
                + ".properties")) {
      properties.load(fis);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load environment configuration for: " + env, e);
    }
  }

  public static String get(ConfigProperty key) {
    if (!properties.containsKey(key.getValue())) {
      throw new RuntimeException("Property not found: " + key.getValue());
    }
    return properties.getProperty(key.getValue());
  }
}
