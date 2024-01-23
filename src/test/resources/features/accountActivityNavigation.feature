Feature: Account Activity Navigation

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Account Summary" menu

  @accountActivity2
  Scenario Outline: Account Activity - 2 Tests
    When Go to "<Account Type>"
    Then Validate that user is on the "<Url>" is as expected
    Then Validate that "<Selected Dropdown>" is as expected
    Examples:
      | Account Type | Url                                                                   | Selected Dropdown |
      | Savings      | http://zero.webappsecurity.com/bank/account-activity.html?accountId=1 | Saving            |
      | Brokerage    | http://zero.webappsecurity.com/bank/account-activity.html?accountId=6 | Brokerage         |
      | Checking     | http://zero.webappsecurity.com/bank/account-activity.html?accountId=2 | Checking          |
      | Credit Card  | http://zero.webappsecurity.com/bank/account-activity.html?accountId=5 | Credit Card       |
      | Loan         | http://zero.webappsecurity.com/bank/account-activity.html?accountId=4 | Loan              |