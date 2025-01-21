package com.donesvad.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

public class ReflectionUtil {

  public static String toUpperCamelCase(String string, boolean firstLetterUpper) {
    char delimiter = ' ';
    boolean shouldConvertNextCharToLower = !firstLetterUpper;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      char currentChar = string.charAt(i);
      if (currentChar == delimiter) {
        shouldConvertNextCharToLower = false;
      } else if (shouldConvertNextCharToLower) {
        builder.append(Character.toLowerCase(currentChar));
      } else {
        builder.append(Character.toUpperCase(currentChar));
        shouldConvertNextCharToLower = true;
      }
    }
    return builder.toString();
  }

  public static Map<String, Class<?>> findAllClassesUsingClassLoader(String packageName) {
    try (InputStream stream =
        ClassLoader.getSystemClassLoader()
            .getResourceAsStream(packageName.replaceAll("[.]", "/"))) {
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(Objects.requireNonNull(stream)));
      Map<String, Class<?>> result = new HashMap<>();
      reader
          .lines()
          .collect(Collectors.toList())
          .forEach(
              line -> {
                if (line.endsWith(".class")) {
                  Class<?> aClass = getClass(line, packageName);
                  result.put(aClass.getSimpleName(), aClass);
                } else {
                  result.putAll(findAllClassesUsingClassLoader(packageName + "." + line));
                }
              });
      return result;
    } catch (Exception e) {
      return new HashMap<>();
    }
  }

  @SneakyThrows
  private static Class<?> getClass(String className, String packageName) {
    return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
  }
}
