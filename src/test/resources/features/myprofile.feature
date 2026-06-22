Feature: My Profile page

  Scenario Outline: Update My Profile Information as an Omani Candidate
    Given the user opens the MHT Eportal website
    When the user clicks the login button
    And the user chooses to log in with PKI
    When the user chooses to log in with Form Authentication
    Then the login page should display successfully
    Then Wait till mobile numberPage loads
    And Input the mobile number "<PKID>"
    Then Click on the Login in Mobile PKI Option
    Then Verify you're logged by Clicking on My Profile option in Admin
    And Click on My Profile Update
    And My Profile Update Form should appear
    Then Input the Id expiry "<ExpiryDate>" to update the form
    Examples:
      | PKID    | ExpiryDate |
      | 1952951 |  2027-08-31 00:00:00.0000000 |