package com.donesvad;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GitHubPage {

  public SearchResultsPage searchRepositoryByName(String repositoryName) {
    $(".search-input").click();
    $("#query-builder-test").setValue(repositoryName).pressEnter();
    return page(SearchResultsPage.class);
  }
}
