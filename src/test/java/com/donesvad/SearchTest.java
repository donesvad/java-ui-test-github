package com.donesvad;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import java.util.function.Predicate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;

class SearchTest {

  @Test
  void userAbleToSearchARepo() {
    String repositoryName = "gitignore";
    GitHubPage gitHubPage = open("https://github.com/", GitHubPage.class);

    SearchResultsPage resultsPage = gitHubPage.searchRepositoryByName(repositoryName);
    ElementsCollection results = resultsPage.getResults();
    results.shouldHave(sizeGreaterThan(1));
    results.get(0).shouldHave(text(repositoryName));
  }

  @Disabled(
      "This test is disabled because the current search implementation do a 'match best' search")
  @Test
  void userUnableToFindNonExistentRepo() {
    String repositoryName = "non-existent";
    GitHubPage gitHubPage = open("https://github.com/", GitHubPage.class);

    SearchResultsPage resultsPage = gitHubPage.searchRepositoryByName(repositoryName);
    ElementsCollection results = resultsPage.getResults();
    Predicate<WebElement> repoNameEqualTo =
        webElement ->
            webElement
                .findElement(ByClassName.className("text-normal"))
                .getText()
                .split("/")[1]
                .equals(repositoryName);
    results.shouldHave(
        noneMatch("No one of the repositories should have a non-existent name", repoNameEqualTo));
  }
}
