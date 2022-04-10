package com.cucumber.framework.stepdefinition;

import java.util.Map;

import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.helper.Navigation.NavigationHelper;
import com.cucumber.framework.helper.PageObject.UploadDocument.UploadDocument;
import com.cucumber.framework.helper.PageObject.homepage.BizzLogin;
import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
import com.cucumber.framework.helper.PageObject.userdetails.Userdetails;
import com.cucumber.framework.settings.ObjectRepo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BizzLoginPage {

	public BizzLogin hPage;
	public NavigationHelper url;

	public PropertyFileReader propertyFileReader;
	public UploadDocument myDrive_UploadDOc;

	@Given("^I am at Bizztree launch Page$")
	public void i_am_at_Facebook_launch_Page() throws Throwable {
		url = new NavigationHelper(ObjectRepo.driver);
		url.navigateTo(ObjectRepo.reader.getWebsite());
		// throw new PendingException();
	}

	@Then("^I Enter Valid UserName \"([^\"]*)\" and Valid Password \"([^\"]*)\"$")
	public void _enter_Valid_Username_And_Password(String userName, String password) throws InterruptedException {
		// hPage.txt_UserName(C);
		hPage = new BizzLogin(ObjectRepo.driver);
		hPage.waitForElement(hPage.txt_UserName, 30);
		hPage.enterUserName(userName);
		hPage.enterPassword(password);
	} 
	
	@Then("^I Enter Valid credentials$")
	public void _enter_Valid_Credentials(DataTable dataTable) throws InterruptedException {
		for(Map<String , String> data :dataTable.asMaps() ) {
		// hPage.txt_UserName(C);
	String uName = data.get("userName");
	String pwd = data.get("password");
		hPage = new BizzLogin(ObjectRepo.driver);
		hPage.waitForElement(hPage.txt_UserName, 30);
		hPage.enterUserName(uName);
		hPage.enterPassword(pwd);
	} 
	}

	@Then("^I Click On Login button$")
	public void _click_Login() throws InterruptedException {
		
		hPage.waitForElement(hPage.btn_login, 30);
		hPage.clickLogin();
		Thread.sleep(10000);
		hPage.waitForElement(hPage.my_Drive_Text, 30);
//		hPage.waitForElement(myDrive_UploadDOc.add_Btn, 30);
//		myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.add_Btn, 30);
		
	}

//	@Then("^I click on add button$")
//	public void _click_AddBtn() throws InterruptedException {
////		myDrive_UploadDOc.waitForElement(myDrive_UploadDOc.add_Btn, 30);
//		Thread.sleep(10000);
//		myDrive_UploadDOc.clickAdd();
		
//	}
}
