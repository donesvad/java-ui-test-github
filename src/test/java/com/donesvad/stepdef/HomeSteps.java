package com.donesvad.stepdef;

import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.en.Given;

public class HomeSteps extends BaseSteps {
  @Given("user opens the application")
  public void userOpensTheApp() {
    open(getBaseUrl());
  }
}
