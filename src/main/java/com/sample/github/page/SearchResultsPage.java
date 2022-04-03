package com.sample.github.page;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class SearchResultsPage {

    public ElementsCollection getResults() {
        return $$(".repo-list-item");
    }
}
