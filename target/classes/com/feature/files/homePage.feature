@HomePage
Feature: Verify the title logo

  Background: 
    Given launch the browser

  Scenario: User Verify the Title logo
    Then verify the logo
    Then verify the image is present or not

  Scenario: User verify wheather all the link are valid
    Then click the add customer and verify
    Then click the add tariff plan and verify
    Then click the add tariff plan to customer and verify
    Then click the pay billing and verify
