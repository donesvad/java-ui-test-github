package com.donesvad.stepdef;

import static com.donesvad.enums.ConfigProperty.PASSWORD;
import static com.donesvad.enums.ConfigProperty.USERNAME;

import com.donesvad.page.DeviceVerificationPage;
import com.donesvad.page.LoginPage;
import com.donesvad.util.ConfigManager;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

  private final LoginPage loginPage = new LoginPage();
  private final DeviceVerificationPage deviceVerificationPage = new DeviceVerificationPage();

  private final String username = ConfigManager.get(USERNAME);
  private final String password = ConfigManager.get(PASSWORD);

  @When("user enters {string} username")
  public void userEntersUsername(String username) {
    if (username.equals(USERNAME.getValue())) {
      username = this.username;
    }
    loginPage.inputLogin(username);
  }

  @When("user enters {string} password")
  public void userEntersPassword(String password) {
    if (password.equals(PASSWORD.getValue())) {
      password = this.password;
    }
    loginPage.inputPassword(password);
  }

  @When("user clicks to the submit button")
  public void userClicksToTheSubmitButton() {
    loginPage.submit();
  }

  @When("device verification page is displayed")
  public void deviceVerificationPageIsDisplayed() {
    deviceVerificationPage.shouldBeVisible();
  }
}
