Feature: Purchase Foreign Currency

  Background:
    Given User is on the zeroBank page
    When Tap on signIn button
    When Enter valid credentials and tap on signIn button
    When Tap on back button
    When Tap on "Online Banking" section
    When Tap on "Pay Bills" menu

  @availableCurrency
  Scenario: Available currencies
    Given Go to "Purchase Foreign Currency" section
    Then Validate that following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @error
  Scenario: Error message for not selecting currency
    Given Go to "Purchase Foreign Currency" section
    When Tap on purchase button
    Then Validate error popUp