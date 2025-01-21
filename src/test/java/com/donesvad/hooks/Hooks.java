package com.donesvad.hooks;

import static com.donesvad.enums.ConfigProperty.BROWSER;
import static com.donesvad.enums.ConfigProperty.HEADLESS;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.donesvad.util.ConfigManager;
import com.donesvad.util.CustomWebDriverListener;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;

public class Hooks {

  @BeforeAll
  public static void setUp() {
    Configuration.browser = ConfigManager.get(BROWSER);
    Configuration.headless = Boolean.parseBoolean(ConfigManager.get(HEADLESS));
    WebDriverRunner.addListener(new CustomWebDriverListener());
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }
}
