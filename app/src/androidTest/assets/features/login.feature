@signup
Feature: Signing up to the application

  @ScenarioId("C8122") @all
  Scenario: C8122
    Given I enter "Monday January 1st" and "Meeting in New york" on first screen on device 1
    And   I let device 2 to finish its step
    Given I enter "Monday January 1st" and "Meeting in New york" on first screen on device 2
    And   I let device 1 to finish its step
    Then  I press submit on first screen on device 1
    And   I let device 2 to finish its step
    Then  I press submit on first screen on device 2
    And   I let device 1 to finish its step
    Given I enter "Wednesday February 2nd" and "All hands meeting" on second screen on device 1
    And   I let device 2 to finish its step
    Given I enter "Wednesday February 2nd" and "All hands meeting" on second screen on device 2
    And   I let device 1 to finish its step
    Then  I press submit on second screen on device 1
    And   I let device 2 to finish its step
    Then  I press submit on second screen on device 2
    And   I let device 1 to finish its step
    Given I enter "Friday March 1st" and "Spring Break Vacation" on third screen on device 1
    And   I let device 2 to finish its step
    Given I enter "Friday March 1st" and "Spring Break Vacation" on third screen on device 2
    And   I let device 1 to finish its step
    Then  I press submit on third screen on device 1
    And   I let device 2 to finish its step
    Then  I press submit on third screen on device 2

