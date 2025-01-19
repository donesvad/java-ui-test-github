package com.donesvad;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class SearchResultsPage {

    public ElementsCollection getResults() {
    return $$("[data-testid='results-list'] > div");
    }
}
