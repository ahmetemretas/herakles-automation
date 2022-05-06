@aet
Feature:Mission 2

  Scenario: verift js alert message
    Given navigate to the url
    Given Click on the Generate random number button
    And Click on the Verify number button
    When Verify a JS alert message is displayed
    Then Verify the alert message is "Write the number first!"
