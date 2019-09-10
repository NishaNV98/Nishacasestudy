
@tag
Feature: LOGIN ACTION
  Login Action Functionality

  @tag1
  Scenario: Successfull login with valid credentials
    Given navigate to homepage
    When user enters username and password
      | username  | password    |
      | Lalitha   | Password123 | 
      | Rick      | Rick123     | 
      | Andrew    | Andrew123   |
   Then message Login Successfully 
