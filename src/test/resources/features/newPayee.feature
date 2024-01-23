Feature: Add new payee under pay bills

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Pay Bills" menu

  @payee
  Scenario: Add a new payee
    Given Go to "Add New Payee" section
    And Create new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    And Tap on Add button
    Then Message The new payee The Law Offices of Hyde, Price & Scharks was should successfully created. should be displayed