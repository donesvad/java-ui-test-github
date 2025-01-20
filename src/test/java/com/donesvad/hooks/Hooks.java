package com.donesvad.hooks;

import static com.donesvad.enums.ConfigProperty.BROWSER;

import com.codeborne.selenide.Configuration;
import com.donesvad.util.ConfigManager;
import io.cucumber.java.BeforeAll;

public class Hooks {

  @BeforeAll
  public static void setUp() {
    Configuration.browser = ConfigManager.get(BROWSER);
  }
}
