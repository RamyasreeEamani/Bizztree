Feature: Bizz application login

  @chrome
  Scenario Outline: Successfully Loggedinto Bizztree
    Given I am at Bizztree launch Page
    #Then I Enter Valid UserName "<userName>" and Valid Password "<password>"
    Then I Enter Valid credentials
    |userName|password|     
    |ramya-sree.eamani@biztree.com|Password1234|
    Then I Click On Login button
    Then I click on add button
    Then I Click On NewFolder
    Then I Enter New Folder Name
    |folderName|
    |TestFolder1|
    Then I Click Create
   // Then I Select CreatedFolder//
    
    
    #Then I Click On Collapse button
    
    
    #
     #Examples: 
      #|userName|password|     
      #|ramya-sree.eamani@biztree.com|Password1234|
      
   