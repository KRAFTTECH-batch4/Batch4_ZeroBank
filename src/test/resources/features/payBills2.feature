@pay2
Feature: Pay Bills checks

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Pay Bills" menu
    Then Validate that user is on the pay bills page

  @positiveScenario
  Scenario: Positive Pay Bills Testt
    When Enter "50", "2023-08-04" and "Test"
    When User taps on Pay button
    Then Validate that success message is visible

  @negativeAmountScenario
  Scenario: Negative Pay Bills Testt (empty amount)
    When Enter "", "2023-08-04" and ""
    When User taps on Pay button
    Then Validate that error message appears on the amount box

  @negativeDateScenario
  Scenario: Negative Pay Bills Testt (empty date)
    When Enter "50", "" and ""
    When User taps on Pay button
    Then Validate that error message appears on the date box

  @negativeInvalidCharacterScenario
  Scenario: Negative Pay Bills Testt (invalid character for date box)
    When Enter "50", "abc" and "Test"
    Then Validate that date box is still empty
    Then Validate that error message appears on the date box
