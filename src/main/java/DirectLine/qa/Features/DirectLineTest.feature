Feature: Direct Line QA Engineer Test 

Scenario: To check if vehicle reg number exists or not
Given I am on the Dealer portal page   
And I check for the title of the page
When I enter the vehicle registration number in the given text box
Then I should see the result displayed below the text box

Scenario: To verify validation message when registration number is empty
Given I am on the Dealer portal page 
When I keep registration number box empty
And I click on Find vehicle button
Then I should see the validation message on the UI

Scenario: To verify validation message when registration number is invalid
Given I am on the Dealer portal page 
When I enter invalid reg number 
And I click on Find vehicle button
Then I should see the validation message
