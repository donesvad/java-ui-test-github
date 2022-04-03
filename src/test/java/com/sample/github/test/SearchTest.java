package com.sample.github.test;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.sample.github.page.GitHubPage;
import com.sample.github.page.SearchResultsPage;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;

class SearchTest {

    @Test
    void userAbleToSearchARepo() {
        open("https://github.com/");
        String repositoryName = "gitignore";
        new GitHubPage().searchRepositoryByName(repositoryName);

        SearchResultsPage resultsPage = new SearchResultsPage();
        ElementsCollection results = resultsPage.getResults();
        results.shouldHave(sizeGreaterThan(1));
        results.get(0).shouldHave(text(repositoryName));
    }

    @Test
    void userUnableToFindNonExistentRepo() {
        open("https://github.com/");
        String repositoryName = "non-existent";
        new GitHubPage().searchRepositoryByName(repositoryName);

        SearchResultsPage resultsPage = new SearchResultsPage();
        ElementsCollection results = resultsPage.getResults();
        Predicate<WebElement> repoNameEqualTo = webElement -> webElement.findElement(ByClassName.className("text-normal"))
            .getText()
            .split("/")[1].equals(repositoryName);
        results.shouldHave(noneMatch("No one of the repositories should have a non-existent name", repoNameEqualTo));
    }
}
