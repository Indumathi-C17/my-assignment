Feature: Retirement Savings Calculator

  Background:
    Given the user is on the Retirement Savings Calculator page
    When the user enters the current age
    And the user enters the retirement age
    And the user enters the current annual income
    And the user enters the spouse’s annual income
    And the user enters the current retirement savings
    And the user enters the current retirement contribution
    And the user enters the annual retirement contribution increase

  @calculator1
  Scenario: Submit the form with all required fields filled in with addition social security income 
    And the user toggles Social Security Income as Yes
    And the user selects relationship status
    And the user enters the Social Security Override amount
	  When the user submits the form
    Then the calculator should display the retirement savings results
    
  @calculator2
  Scenario: Submit the form with all required fields filled in without addition social security income 
    And the user toggles Social Security Income as No
	  When the user submits the form
    Then the calculator should display the retirement savings results    
    
	@update
  Scenario: Update default calculator values
   And the user enters additional/other income
    And the user enters the number of years retirement needs to last
    And the user selects post-retirement income increase with inflation as Yes
    And the user enters the expected inflation rate
    And the user enters the percent of final annual income desired
    And the user enters the pre-retirement investment return
    And the user enters the post-retirement investment return
    When the user submits the form
    Then the calculator should display the retirement savings results