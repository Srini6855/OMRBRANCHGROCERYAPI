@CityList
Feature: City module API documentation

  Scenario: Verify user Get citylist through API
    Given User add headers for to get citylist
    When User add request body stateId for get city list
    And User send "POST" request for citylist endpoint
    Then User should verify the status code is 200
    And User verify the citylist response message matches "Coimbatore" and saved city ID