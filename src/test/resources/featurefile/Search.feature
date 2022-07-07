Feature: Bizz application login and Searching for file

  @chrome
  Scenario Outline: Successfully Loggedinto Bizztree and search file
    Given I am at Bizztree launch Page
    #Then I Enter Valid UserName "<userName>" and Valid Password "<password>"
    Then I Enter Valid credentials
    |userName|password|     
    |ramya-sree.eamani@biztree.com|Password1234|
    Then I search filename
    |file|
    |Test1.txt|
   