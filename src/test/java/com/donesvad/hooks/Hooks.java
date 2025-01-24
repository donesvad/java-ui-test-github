package com.donesvad.hooks;

import static com.donesvad.enums.ConfigProperty.BROWSER;
import static com.donesvad.enums.ConfigProperty.HEADLESS;
import static com.donesvad.enums.ConfigProperty.SELENIUM_HUB_URL;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.donesvad.util.ConfigManager;
import com.donesvad.util.CustomWebDriverListener;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

  @BeforeAll
  public static void setUp() {
    Configuration.browser = ConfigManager.get(BROWSER);
    Configuration.headless = Boolean.parseBoolean(ConfigManager.get(HEADLESS));
    try {
      String remoteUrl = ConfigManager.get(SELENIUM_HUB_URL);
      Configuration.remote = remoteUrl;
      log.info("Remote URL is set to: {}", remoteUrl);
    } catch (Exception e) {
      log.info("No remote URL is set, running tests locally");
    }
    WebDriverRunner.addListener(new CustomWebDriverListener());
    SelenideLogger.addListener(
        "AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }
}
