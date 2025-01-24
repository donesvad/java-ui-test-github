Feature: Search

  Scenario Outline: User can search for a repository
    Given user opens the application
    When user searches for a "<searchRequest>" repository
    Then user is on "search results" page
    And there is at least 1 result
    And there is result with "<searchResult>" title

    Examples:
      | searchRequest | searchResult     |
      | gitignore     | github/gitignore |
      | docker        | jenkinsci/docker |
