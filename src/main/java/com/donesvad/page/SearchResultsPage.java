package com.donesvad.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class SearchResultsPage extends BasePage {
  private final SelenideElement searchResultPageContainer = $(".search-results-page");
  private final ElementsCollection searchResultElements = $$("[data-testid='results-list'] > div");
  private final ElementsCollection searchTitleElements = $$(".search-title");

  @Override
  public void isLoaded() {
    searchResultPageContainer.shouldBe(visible);
  }

  public ElementsCollection getResults() {
    return searchResultElements;
  }

  public ElementsCollection getResultTitles() {
    return searchTitleElements;
  }
}
