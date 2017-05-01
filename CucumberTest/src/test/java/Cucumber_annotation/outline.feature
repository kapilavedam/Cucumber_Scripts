Feature: annotation 

Background: 
   User navigates to Amazon Page Given 
   I am on Amazon page 

Scenario: 
   When I search with text "Nikon"
   When sorted it as Price:High to Low 
   Then Nikon search results with expected order should appear 

Scenario: 
   When I click on the second item in the list 
   When verified the details for text "Nikon D3X" 
   Then message displayed as search text not found
   
