Feature: Account Activity Checks

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
  @accountActivity
  Scenario: Account Activity Test
    When Tap on "Online Banking" section
    When Tap on "Account Activity" menu
    Then Validate that user is on the account activity page
    Then Validate that the default option in dropdown menu is Savings
    Then Validate that the dropdown menu has followings
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Validate that columns have followings
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |