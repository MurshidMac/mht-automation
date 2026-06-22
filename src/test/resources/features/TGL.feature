Feature: Tourist Guide License

  Scenario Outline: Verify the User is able to create a tourist guide license
    Given the user opens the MHT Eportal website
    When the user clicks the login button
    And the user chooses to log in with PKI
    When the user chooses to log in with Form Authentication
    Then the login page should display successfully
    Then Wait till mobile numberPage loads
    And Input the mobile number "<PKID>"
    Then Click on the Login in Mobile PKI Option
    Then Verify you're logged in successfully
    And Click on My Profile option in Admin
    Examples:
      | PKID    |
      | 1952951 |

