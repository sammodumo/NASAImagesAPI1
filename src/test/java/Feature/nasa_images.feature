Feature: Search for images from NASA's API

  Scenario: Search for Mars images
    Given I make a GET request to NASA's image API with the query "Mars"
    Then the response status code should be 200
    And the response should contain the word "Mars"
#
#  Scenario: Search for Moon images
#    Given I make a GET request to NASA's image API with the query "Moon"
#    Then the response status code should be 200
#    And the response should contain the word "Moon"