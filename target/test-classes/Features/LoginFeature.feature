Feature: Login Functionality

	Background: 
		Given user is on Login Page
		
	Scenario Outline: Valid Login
		When user enter username "<Username>"
		When user enter password "<Password>"
		Then user moves to solve page
		Examples:
		|Username|Password|
		|test@test.com|pwdpwdpwd|
		|test2@test.com|pwspwpspws|
		
		
	Scenario Outline: Invalid Login
		When user enter username "<Username>"
		Then user gets error
		Examples:
		|Username|
		|testtest.com|
		|test2@test|

		
#	Scenario: Validate Logo Visibility
	#	Given user is on homepage
		#Then logo is visible