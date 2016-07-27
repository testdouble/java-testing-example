Feature: Walrus 

Background: 
	Given I have a walrus 
	And I have food
	
	
Scenario: unfed walruses 
	When I have not fed the walrus 
	Then the walrus's stomach should not contain any food I pass it 

Scenario: fed walruses
	When I have fed the walrus
	Then the walrus's stomach should contain the food
	
Scenario: feeding canned food to walruses
	Given I put the food in a can
	When I feed the walrus canned food
	Then the walrus's stomach should contain the food
