Feature: Login to MHT Eportal Website
  @smoke @regression @login @MobilePKI
  Scenario Outline: User logs in via PKI
    Given the user opens the MHT Eportal website
    When the user clicks the login button
    And the user chooses to log in with PKI
    When the user chooses to log in with Form Authentication
    And Input the form username "<PKID>"
    And Input the form password "<PKID>"
    Then the login page should display successfully
    Then Wait till mobile numberPage loads
    And Input the mobile number "<PKID>"
    Then Click on the Login in Mobile PKI Option
    Examples:
      | PKID    |
      | 1952951 |

