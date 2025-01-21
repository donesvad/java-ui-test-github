package com.donesvad.component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import com.donesvad.page.SearchResultsPage;
import com.donesvad.page.LoginPage;

public class HeaderComponent {
  private final SelenideElement searchInputButton = $(".search-input");
  private final SelenideElement searchInputExpanded = $("#query-builder-test");
  private final SelenideElement loginButton = $("[href='/login'].HeaderMenu-link--sign-in ");

  public SearchResultsPage searchRepositoryByName(String repositoryName) {
    searchInputButton.click();
    searchInputExpanded.setValue(repositoryName).pressEnter();
    return page(SearchResultsPage.class);
  }

  public LoginPage clickSignInButton() {
    loginButton.click();
    return page(LoginPage.class);
  }
}
