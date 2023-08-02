Feature: Login Tests

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button

  @positiveLogin
  Scenario: Positive Login Test
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    Then Validate that user is on the home page

  @negativeLogin
  Scenario Outline: Negative Login Scenarios
    When Enter "<USERNAME>" AND "<PASSWORD>"
    When Tap on login button
    Then Validate that warning message appears

    Examples:
      | USERNAME      | PASSWORD      |
      | username      | wrongPassword |
      | wrongUsername | password      |
      |               | password      |
      | username      |               |
      |               |               |


