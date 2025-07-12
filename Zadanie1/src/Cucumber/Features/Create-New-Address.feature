Feature: Create new address

  Scenario Outline: logged user can create and delete new address
    Given I'm opening browser with mystore-testlab.coderslab.pl
    When I login on already created account using "pauwoj@test.pl" and "123456789"
    Then I create new address using "<alias>","<address>","<city>","<postal_code>","<country>","<phone>"
    Then I check if the new address is correct with "<alias>","<address>","<city>","<postal_code>","<country>","<phone>"
    Then I delete the new address and check if the address was deleted
    And I close the browser
    Examples:
      | alias | address     | city   | postal_code | country        | phone     |
      | Home  | Wschodnia49 | Warsaw | 02-415      | United Kingdom | 567432990 |