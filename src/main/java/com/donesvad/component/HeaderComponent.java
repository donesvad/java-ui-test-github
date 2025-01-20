package com.donesvad.component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import com.donesvad.page.SearchResultsPage;

public class HeaderComponent {
  private final SelenideElement searchInputButton = $(".search-input");
  private final SelenideElement searchInputExpanded = $("#query-builder-test");

  public SearchResultsPage searchRepositoryByName(String repositoryName) {
    searchInputButton.click();
    searchInputExpanded.setValue(repositoryName).pressEnter();
    return page(SearchResultsPage.class);
  }
}
