Feature: Login to MHT Eportal Website
  @smoke @regression @login @MobilePKI
  Scenario Outline: User logs in via PKI
    Given the user opens the MHT Eportal website
    When the user clicks the login button
    And the user chooses to log in with Form Authentication
    And Input the form username "<PKID>"
    And Input the form password "<PKID>"
    Then Click on the Login Sign
    Examples:
      | PKID    |
      | 1952951 |

