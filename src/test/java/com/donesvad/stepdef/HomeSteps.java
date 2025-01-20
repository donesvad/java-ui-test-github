package com.donesvad.stepdef;

import static com.codeborne.selenide.Selenide.open;

import com.donesvad.component.HeaderComponent;
import io.cucumber.java.en.Given;

public class HomeSteps extends BaseSteps {
  @Given("user is on home page")
  public void userIsOnHomePage() {
    open(getBaseUrl(), HeaderComponent.class);
  }
}
