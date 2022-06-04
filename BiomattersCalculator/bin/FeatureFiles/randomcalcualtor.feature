Feature: Randomly choose a group for each subject
	As a user who likes to generate random assignment of individuals to groups
	I want to generate an assignment in random calculator
	So that I can plan the assignments of individuals

Acceptance Criteria
   - I will navigate to random calculator 
   - I will select assign, subjects to each of and repeat options
   - I will provide random mapping results
   - I will check the mappings in rows and columns
   
Background: 
	Given user has navigate to random calculator
	
Scenario: Generate a list of numbered hypothetical individuals who are assigned to groups for the purposes of a statistical study

Given user provide "2" as Assign, "2" as the Subject to each of and "1" as the Repeat
When user click on Doit button
Then user verify the number of individuals '4' and assignments '2'