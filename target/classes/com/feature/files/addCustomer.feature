Feature: AddCustomers page check

  Background: 
    Given launch the url

  Scenario: User enter to miss some details
    Then enter the details
      | Karthik | Shankar | karthikshankar@gmail.com | 1234567890 |
    Then click the button
    Then The checks wheather the alert is present or not

  Scenario: User check the reset button
    Then enter the details
      | Karthik | Shankar | karthikshankar@gmail.com | 1234567890 |
    Then click the reset button
    Then checks the textboxs are empty

  Scenario Outline: user gives 5 customer number details

    Then User enters the details "<firstname>" "<lastname>" "<email>" "<address>" "<mobnum>"
    Then click the button
    Then get the customer id number

    Examples: 
      | firstname | lastname | email                    | address | mobnum     |
      | Karthik   | Shankar  | karthikshankar@gmail.com | xxxxxx  | 1234567890 |
      | Karthik   | knight   | karthik@gmail.com        | xxxxxx  | 1234567890 |
      | Karthik   | rider    | shankar@gmail.com        | xxxxxx  | 1234567890 |
      | Karthik   | dhanush  | kshankar@gmail.com       | xxxxxx  | 1234567890 |
      | Karthik   | kkr      | karkar@gmail.com         | xxxxxx  | 1234567890 |
