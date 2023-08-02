Feature: Account Summary checks

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button

  @accountSummary
  Scenario: Account Summary Test
    When Tap on "Online Banking" section
    When Tap on "Account Summary" menu
    Then Validate that title is correct
    Then Validate accounts types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Validate credit accounts columns
      | Account     |
      | Credit Card |
      | Balance     |


