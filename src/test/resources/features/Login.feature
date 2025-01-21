Feature: Login

  @smoke
  Scenario: User is able to sign in
    Given user opens the application
    When user clicks to the login button
    Then user is on "login" page
    When user enters "test.username" username
    And user enters "test.password" password
    And user clicks to the submit button
    Then device verification page is displayed
