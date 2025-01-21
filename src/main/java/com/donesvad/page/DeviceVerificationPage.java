package com.donesvad.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class DeviceVerificationPage extends BasePage {
  private final SelenideElement loginForm = $("#login");

  public void shouldBeVisible() {
    loginForm.shouldBe(visible);
  }

  @Override
  public void isLoaded() {
    loginForm.shouldBe(visible);
  }
}
