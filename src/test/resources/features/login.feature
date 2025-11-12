Feature: Login to MOT Website

  Scenario: User logs in via PKI
    Given the user opens the MOT website
    When the user clicks the login button
    And the user chooses to log in with PKI
    Then the login page should display successfully
