Feature: BDD tests for Amazon
  Background: Open the Home Page
    Given User is on Home Page

  Scenario: Testing Cart Page accessibility
    When User click on Cart Button
    Then Cart Page is displayed

  Scenario: Testing the item addition to the Cart Page functionality
    When User searches for an item
    And User clicks on search button
    And User finds an item to be added to the cart
    And User adds the item to the cart
    Then The selected item should be present in the cart

  Scenario Outline: Testing different random names in the search field (negative)
    When User searches for an item named "<itemName>"
    And User clicks on search button
    Then The User is met with an error message for the searched item "<itemName>"


    Examples:
    | itemName |
    | mhsdgvckjasdhvkseuyvbckuvhbUOY@GEUYWGAFDO&WT |
    | __+!_#GIHB@OUBT728t4819 |
    | 1512heOY@GE6g2lvr12iygo8yu3vr |