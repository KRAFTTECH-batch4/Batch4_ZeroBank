Feature: Pay Bills Checks

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Pay Bills" menu

  @positiveScenario
  Scenario: Positive Pay Bills Test
    Then Validate that user is on the pay bills page
    When User sends "50" amount to input box
    When User sends "2023-08-04" date to input box
    When User sends "Test" data to input box
    When User taps on Pay button
    Then Validate that success message is visible

