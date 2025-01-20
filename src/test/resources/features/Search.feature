Feature: Search

  Scenario: User can search for a repository
    Given user is on home page
    When user searches for a "gitignore" repository
    Then user is on search results page
    And there is at least 1 result
    And there is result with "github/gitignore" title
