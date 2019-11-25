Feature: 4shared functional testing
  Verify if user is able to login to 4shared, create folder and upload files

  Background:
    Given I am running test for "local-mac" profile

  Scenario Outline:: Basic functional testing of 4shared site
    Given I successfully login to 4shared with "<UserId>" and "<Password>"
    When I click on new folder option
    Then A new folder is created
    When I upload files in the folder created
    Then files are uploaded

    Examples:
      | UserId                   | Password  |
      | freeqantaswifi@gmail.com | test@9090 |
