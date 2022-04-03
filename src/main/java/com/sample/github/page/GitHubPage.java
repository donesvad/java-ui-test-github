package com.sample.github.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GitHubPage {

    public GitHubPage searchRepositoryByName(String repositoryName) {
        $("[data-test-selector='nav-search-input']").setValue(repositoryName).pressEnter();
        return page(GitHubPage.class);
    }
}
