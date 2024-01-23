Feature: Find Transactions

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Account Activity" menu
    When Click on Find Transactions

  @dateRange
  Scenario: Search Date Range
    When Enter dates from "2012-09-01" to "2012-09-06"
    When Tap on Find button
    Then Validate that results is sorted by most recent date
    Then Validate that results table only show transactions between "2012-09-01" to "2012-09-06"
  @description
  Scenario: Search Description
    When Enter "ONLINE" as description
    When Tap on Find button
    Then Validate that descriptions contain "online"

  Scenario: Type-1
    When Tap on Find button
    Then Validate that results table should show at least 1 result under Deposit
    Then Validate that results table should show at least 1 result under Withdrawal

  Scenario: Type-2
    When Select type "Deposit"
    When Tap on Find button
    Then Validate that results table should show at least one result under Deposit
    But Validate that results table should show no result under Withdrawal
  @type
  Scenario: Type-3
    When Select type "Withdrawal"
    When Tap on Find button
    Then Validate that results table should show at least 1 result under Withdrawal
    But Validate that results table should show no result under Deposit