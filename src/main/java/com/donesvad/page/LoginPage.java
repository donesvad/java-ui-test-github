package com.donesvad.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class LoginPage extends BasePage {
  private final SelenideElement authForm = $(".auth-form");
  private final SelenideElement loginInput = $("#login_field");
  private final SelenideElement passwordInput = $("#password");
  private final SelenideElement submitButton = $("[type='submit']");

  @Override
  public void isLoaded() {
    authForm.shouldBe(visible);
  }

  public void inputLogin(String login) {
    loginInput.setValue(login);
  }

  public void inputPassword(String password) {
    passwordInput.setValue(password);
  }

  public void submit() {
    submitButton.click();
  }
}
