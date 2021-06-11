Feature: ANZ Application page

Scenario: First test
Given user is on homepage
Then user verify title of the homepage
Then user fills application type as single
Then user fills no of dependents as zero
Then user fills property you want to buy 
Then user fills your income
Then user fills your other income
Then user fills living expenses
Then user fills current home loan repayments
Then user fills other loan repayments
Then user fills other commitments
Then user fills credit card limits
And user clicks on work out how much i could borrow button
Then user clicks on start over button
Then user enters living expenses and leaves everything blank
And display message on the screen