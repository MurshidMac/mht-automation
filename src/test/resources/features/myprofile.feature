Feature: My Profile page

  Scenario Outline: Update My Profile Information as an Omani Candidate
    Given the user opens the MOT website
    When the user clicks the login button
    And the user chooses to log in with PKI
    Then the login page should display successfully
    Then Wait till mobile numberPage loads
    And Input the mobile number "<PKID>"
    Then Click on the Login in Mobile PKI Option

    Examples:
      | PKID    |
      | 1952951 |