Feature: Make call GET

  Scenario: the client makes GET request
    When the client calls /cucumbers
    Then the client receives status code of 200
    And  the client receives a response "Hello cucumbers"
  Scenario: client gets a cucumber
    When the client calls /cucumbers/cucumber
    Then the client receives from /cucumbers/cucumber status code of 200
    And  the client receives a ResponseEntity