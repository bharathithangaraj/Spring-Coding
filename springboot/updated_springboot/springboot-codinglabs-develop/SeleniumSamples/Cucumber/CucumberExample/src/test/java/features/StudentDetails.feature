Feature: Student details tests

  Scenario: Initial count of students
    Given User is on the students login page
    When User logs in with user name "admin" and password "admin"
    Then Initial user count should be "100"

  Scenario: Login error validation
    Given User is on the students login page
    When User logs in with user name "admin123" and password "admin123"
    Then The user should get error message