package com.cucumber.framework.helper.PageObject.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.PageObject.PageBase;
import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
import com.cucumber.framework.helper.TextBox.TextBoxHelper;
import com.cucumber.framework.settings.ObjectRepo;


public class BizzLogin extends PageBase {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(BizzLogin.class);

	public BizzLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	
	@FindBy(how=How.XPATH,using="//input[@id = 'Email']")
	public WebElement txt_UserName;
	
	@FindBy(how=How.XPATH,using="//input[@id = 'Password']")
	public WebElement txt_Password;
	
	@FindBy(how=How.XPATH,using="//button[text() = 'Log in']")
	public WebElement btn_login;
	
	@FindBy(how=How.XPATH,using="//span[contains(text() , 'My Drive')]")
	public WebElement my_Drive_Text;

	
	/** Public Methods  **/
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void enterUserName(String userName) {
		txt_UserName.sendKeys(userName);
		log.info(userName);
	}
	
	public void enterPassword(String pwd) {
		txt_Password.sendKeys(pwd);
		log.info(pwd);
	}
	
	public void clickLogin() {
		btn_login.click();
		
	}
	

	
	
}
