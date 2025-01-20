package com.donesvad.stepdef;

import com.donesvad.component.HeaderComponent;
import io.cucumber.java.en.When;

public class HeaderSteps {

  private final HeaderComponent headerComponent = new HeaderComponent();

  @When("user searches for a {string} repository")
  public void userSearchesForAGitignoreRepository(String repoToSearch) {
    headerComponent.searchRepositoryByName(repoToSearch);
  }
}
