#Author: manijambakula3907@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
# (Comments)
#Sample Feature Definition Template


Feature: Job Search Functionality in NHS application
  

  @search
  Scenario Outline: Search for a Job with Job Title or Skills
    Given I am a jobseeker on NHS Jobs application
    When I put my <jobTitle> <location> preferences into the Search functionality
    Then I should get a list of jobs which matches my preferences
    And sort my search results according to the <sortselection>
    
    Examples:
    |jobTitle							|location			|sortselection				|
    |Clinical Specialist	|London				|Date Posted (newest)	|
