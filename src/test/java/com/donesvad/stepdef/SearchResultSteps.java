package com.donesvad.stepdef;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

import com.donesvad.page.SearchResultsPage;
import io.cucumber.java.en.Then;

public class SearchResultSteps extends BaseSteps {

  private final SearchResultsPage searchResultsPage = new SearchResultsPage();

  @Then("there is at least {int} result")
  public void resultsPageHasAtLeastResult(int expectedMinimumSize) {
    searchResultsPage.getResults().shouldHave(sizeGreaterThan(expectedMinimumSize));
  }

  @Then("there is result with {string} title")
  public void theFirstResultIs(String repositoryName) {
    searchResultsPage.getResultTitles().shouldHave(itemWithText(repositoryName));
  }
}
