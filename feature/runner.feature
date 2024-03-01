#Author: your.email@your.domain.com
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
## (Comments)
#Sample Feature Definition Template
@strip_redirection_withoutLogin_verifieduser
Feature: stripe redirection withoutLogin verifieduser
  I want to use this template for my feature file

  @signup
  Scenario: signup
    Given generate email
    When signup
    And verify email

  @monthly_to_monthly_scenario_logout_state
  Scenario Outline: monthly to basic stripe navigation
    Given set the credential to current plan <current_planid> and <current_mode> with <selected_planid>
    And choose the plan <selected_planid> and <selected_mode>
    When login
    Then page navigation <page>

    @monthly->to->monthly
    Examples: 
      | current_planid | current_mode | selected_planid | selected_mode | page       |
      |              1 | "m"          |               1 | "m"           | "onthefly" |
      |              1 | "m"          |               2 | "m"           | "stripe"   |
      