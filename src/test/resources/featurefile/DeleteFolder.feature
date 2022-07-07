Feature: Bizz application login and adding and selecting folder and delete folder

  @chrome
  Scenario Outline: Successfully Deleted Folder
    Given I am at Bizztree launch Page
    #Then I Enter Valid UserName "<userName>" and Valid Password "<password>"
    Then I Enter Valid credentials
    |userName|password|     
    |ramya-sree.eamani@biztree.com|Password1234|
    Then I Click On Login button
    Then I Select Created Folder
    Then I delete selected folder
    