Feature: 'Home' page and 'Different elements' page

  Scenario: Check interface and content of 'Home' and 'Different elements' pages.
    Given I am on the Home Page
    Then Home Page is the browser title
    When I login as user PITER_CHAILOVSKII
    Then PITER_CHAILOVSKII name is displayed on the header
    And Home Page contains 4 pictures, 4 texts under them and 2 texts above
    When I open the Different Elements Page
    Then Different Elements is the browser title
    And Interface on Different elements page contains all needed elements
    And There is Left Section
    And There is Right Section
    When I select checkbox: Water
    And I select checkbox: Wind
    Then There is a log row number 1 for checkbox Wind. State true
    And There is a log row number 2 for checkbox Water. State true
    When I select radio: Selen
    Then There is a log for radio Selen
    When I select in dropdown: Yellow
    Then There is a log for color Yellow
    When I select checkbox: Water
    And I select checkbox: Wind
    Then There is a log row number 1 for checkbox Wind. State false
    And There is a log row number 2 for checkbox Water. State false
