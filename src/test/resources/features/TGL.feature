Feature: Tourist Guide License

  Scenario Outline: Verify the User is able to create a tourist guide license
    Given the user opens the MHT Eportal website
    When the user clicks the login button
    And the user chooses to log in with Form Authentication
    And Input the form username "<PKID>"
    And Input the form password "<PKID>"
    Then Click on the Login Sign
    Then Verify you're logged in successfully
    And Click on My Profile option in Admin
    Examples:
      | PKID    |
      | 1952951 |

