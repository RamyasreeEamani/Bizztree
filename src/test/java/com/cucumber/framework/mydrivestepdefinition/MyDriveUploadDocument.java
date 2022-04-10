package com.cucumber.framework.mydrivestepdefinition;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.cucumber.framework.helper.Alert.AlertHelper;
import com.cucumber.framework.helper.Navigation.NavigationHelper;
import com.cucumber.framework.helper.PageObject.UploadDocument.UploadDocument;
import com.cucumber.framework.helper.PageObject.homepage.BizzLogin;
import com.cucumber.framework.settings.ObjectRepo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyDriveUploadDocument  {
	public BizzLogin hPage;
	public NavigationHelper url;
	public UploadDocument myDrive_UploadDOc;
	public AlertHelper Alert;
	public MyDriveUploadDocument() {
		myDrive_UploadDOc = new UploadDocument(ObjectRepo.driver);
		Alert =new AlertHelper(ObjectRepo.driver);
	}
	
	@Then("^I Click On Expansion Button$")
	public void _click_Expansion_Btn() {
		
		//myDrive_UploadDOc = new UploadDocument(ObjectRepo.driver);
		myDrive_UploadDOc.clickExpansionButton();
		
	}
	@Then("^I Click On Collapse button$")
	public void _click_CollapseBtn() {
		
		myDrive_UploadDOc.clickCollapseButton();
		
	}
	
	@Then("^I click on add button$")
	public void _click_AddBtn() throws InterruptedException {
//		myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.add_Btn, 30);
		
		myDrive_UploadDOc.clickAdd();
		
		myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.add_NewFolder, 30);
		
		
		
	}

	@Then("^I Click OnUploadFile$")
	public void _click_UploadFile() {
		
		myDrive_UploadDOc.clickUploadFileButton();
		
	}
	@Then("^I Click On UploadFolder$")
	public void _click_UploadFolder() {
		
		myDrive_UploadDOc.clickUploadFoler();	
	}
	
	@Then("^I Click On NewFolder$")
	public void _click_NewFolder() {
		
		myDrive_UploadDOc.clickNewFolder();
	}
	@Then("^I Enter and create Folder Name$")
	public void _enter_FolderName(String folderName) {
		
		
		
		myDrive_UploadDOc.enterNewFolder(folderName);
		myDrive_UploadDOc.clickCreate();
	}
	
	@Then("^I Enter New Folder Name$")
	public void _enter_FolderName(DataTable dataTable) throws InterruptedException {
		for(Map<String , String> data :dataTable.asMaps() ) {
		// hPage.txt_UserName(C);
	String FolderName = data.get("folderName");
//	String pwd = data.get("password");
	
	myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.add_FolderName, 30);
	myDrive_UploadDOc.enterNewFolder(FolderName);
//	myDrive_UploadDOc.clickCreate();
//		hPage.enterPassword(pwd);
	} 
	}
	@Then("^I Click Create$")
	public void _click_Create() {
		
		myDrive_UploadDOc.clickCreate();
		myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.created_FolderName, 30);
	}
	@Then("^I Select CreatedFolder$")
	public void _click_CreatedFolder() {
		
		myDrive_UploadDOc.clickCreatedFolder();
		
	}
	@Then("^I Delete Created Folder$")
	public void _deleteFolder() throws InterruptedException {
		
		myDrive_UploadDOc.deleteCreatedFolder();
		
	}
	@Then("^I Click om File Loaction$")
	public void _click_DragFilesHere() throws AWTException, InterruptedException {
		
		myDrive_UploadDOc.dropFolderssHere();	
		Thread.sleep(1000);
		
	}
	@Then("^I Enter Folder Loaction \"([^\"]*)\"$")
	public void _file_Locaction(String fileName) throws AWTException, InterruptedException {
		

	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		StringSelection stringSelection = new StringSelection(fileName);
		
		
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		
		clipboard.setContents(stringSelection, null);
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_TAB);
		  robot.keyRelease(KeyEvent.VK_TAB);
		//Simulate Enter key event
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(12000);
		//Alert.AcceptAlert();
		robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
