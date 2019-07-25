Feature: User Login

  @testLogin-scenarios
  Scenario: Verify the registration functionality
    When I open the App
    Then  I can fill form
    And  I can save the form
    And  I can click the user that I just created
    And  I go back to the UserList Screen
    And  I can Delete the user
