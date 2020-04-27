@AddCustomer
Feature: AddCustomers page check

  Background: 
    Given launch the url

  Scenario: User missed to enter some details
    When the user enter the details
      | Karthik | Shankar | karthikshankar@gmail.com | 1234567890 |
    And click the button
    Then checks wheather the alert is present or not

  Scenario: User checks the reset button
    When the user enter the details
      | Karthik | Shankar | karthikshankar@gmail.com | 1234567890 |
    And click the reset button
    Then checks wheather the textbox is empty or not

  Scenario Outline: user gives 5 customer number details
    When User enters the details "<firstname>" "<lastname>" "<email>" "<address>" "<mobnum>"
    And click the button
    Then get the customer id number

    Examples: 
      | firstname | lastname | email                    | address | mobnum     |
      | Karthik   | Shankar  | karthikshankar@gmail.com | xxxxxx  | 1234567890 |
      | Karthik   | knight   | karthik@gmail.com        | xxxxxx  | 1234567890 |
      | Karthik   | rider    | shankar@gmail.com        | xxxxxx  | 1234567890 |
      | Karthik   | dhanush  | kshankar@gmail.com       | xxxxxx  | 1234567890 |
      | Karthik   | kkr      | karkar@gmail.com         | xxxxxx  | 1234567890 |
