@tariffPlan
Feature: Add customer and tariff

  Scenario: User create a customer id
    Given user on the application
    When the user enter the customer details
      | Karthik | Shankar | karthikshankar@gmail.com | xxxx | 1234567890 |
    Then click the submit button
    And get the customer Id
    Then user on the tariff page
    When the user enter the tariff details
      | 300 | 1000 | 250 | 100 | 1 | 3 | 1 |
    Then user click the submit button
    Then user on the page
    When the user enter the customer id
    And the user click ok
    Then the user choose the tariff plan
    And the user click ok button
    Then User on the bill payment page
    Then the user check his bill
