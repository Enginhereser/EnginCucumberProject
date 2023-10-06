Feature: Home Page

  Background: Homepage
    Given user go to the Homepage

  Scenario: On the right side links
    Given hover over to Services
    When  click the button Abschlussprufung
    And   click on the right of page the button zur Angebotsanfrage
    Then  verify color of input field
    And   click the button Übermitteln
    Then  verify color of input field and error message
    And   Fill in the mandatory fields
      | Engin                  |
      | Hereser                |
      | enginhereser@gmail.com |
      | Deutschland            |
    








