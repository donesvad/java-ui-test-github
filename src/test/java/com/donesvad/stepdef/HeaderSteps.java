package com.donesvad.stepdef;

import com.donesvad.component.HeaderComponent;
import io.cucumber.java.en.When;

public class HeaderSteps extends BaseSteps {

  private final HeaderComponent headerComponent = new HeaderComponent();

  @When("user searches for a {string} repository")
  public void userSearchesForAGitignoreRepository(String repoToSearch) {
    headerComponent.searchRepositoryByName(repoToSearch);
  }

  @When("user clicks to the login button")
  public void userClicksToTheLoginButton() {
    headerComponent.clickSignInButton();
  }
}
