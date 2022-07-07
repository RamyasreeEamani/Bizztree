package com.cucumber.framework.helper.PageObject.UploadDocument;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.PageObject.PageBase;
import com.cucumber.framework.helper.PageObject.homepage.BizzLogin;

public class UploadDocument extends PageBase
{

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(UploadDocument.class);

	public UploadDocument(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	
	@FindBy(how=How.XPATH,using="//div[contains(text(), 'Create / Upload')]/..")
	public WebElement add_Btn;
	
	@FindBy(how=How.XPATH,using = "(//div[@class ='icon icon--secondary'])[6]")
	public WebElement add_Expansion_Btn;
	
	@FindBy(how=How.XPATH,using = "(//div[@class ='icon icon--secondary'])[6]")
	public WebElement add_Collapse_Btn;
	
	@FindBy(how=How.XPATH,using = "(//span[text() = 'Upload Files '])[2]")
	public WebElement add_UploaFile;
	
	@FindBy(how=How.XPATH,using = "(//span[text() = 'Upload Folder '])[2]")
	public WebElement add_UploadFolder;
	
	@FindBy(how=How.XPATH,using = "(//div[contains(text(), 'Upload')])[3]")
	public WebElement upload_Btn;
	
	
	
	@FindBy(how=How.XPATH,using = "(//span[contains(text(), 'New Folder ')])[2]")
	public WebElement add_NewFolder;
	
	@FindBy(how=How.XPATH,using = "//input[@placeholder = 'Enter folder name...']")
	public WebElement add_FolderName;

	@FindBy(how=How.XPATH,using = "//div[@id ='1']")
	public WebElement created_FolderName;
	
		
	
	@FindBy(how=How.XPATH,using = "//div[text() = 'Create']")
	public WebElement click_CreateBtn;
	
	
	@FindBy(how=How.XPATH,using = "//div[text() = 'Cancel']")
	public WebElement click_CancelBtn;
	
	@FindBy(how=How.XPATH,using = "//h5[contains(text(), 'Drop folder here or click to upload')]")
	public WebElement droFolderHere;
	
	@FindBy(how=How.XPATH,using = "//h5[contains(text(), 'Drop files here or click to upload')]")
	public WebElement droFilesHere;

	@FindBy(how=How.XPATH,using = "(//span[contains(text(), 'New Document ')])[2]")
	public WebElement newDocument_BTN;
	
	@FindBy(how=How.XPATH,using = "(//span[contains(text(), 'New Spreadsheet ')])[2]")
	public WebElement newSpreadsheet_BTN;
	
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Paste folder ')]")
	public WebElement pasteFolder_BTN;
	
	@FindBy(how=How.XPATH,using = "(//div[contains(@class, 'shape-circle')])[7]")
	public WebElement click_Threedots;
	
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Delete')]")
	public WebElement delete_Folder;
	
	@FindBy(how=How.XPATH,using = "//a[contains(text(), 'Yes, delete this folder')]")
	public WebElement confirm_DeleteFolder;
	
	
	
	@FindBy(how=How.XPATH,using = "//div[@id = 'drag-area0']//span")
	public WebElement select_createdFolder;
	
	
	@FindBy(how=How.XPATH,using = "//div[contains(text(), 'Share')]")
	public WebElement share_Button;
	
	@FindBy(how=How.XPATH,using = "//div[@id = 'file0']")
	public WebElement selectFile;
	
	@FindBy(how=How.XPATH,using = "//div[@class = 'icon favorite__icon icon--gray5']")
	public WebElement favorite_Btn;
	
	
	
	
	/** Public Methods  **/
	
	public WebDriver getDriver() {
		return this.driver;
	}
	

	
	public void clickAdd() {
		
		add_Btn.click(); 
		
	}
	
	public void selectCreatedFolder() {
		
		select_createdFolder.click(); 
		select_createdFolder.click(); 
		
	}
	

public void deleteCreatedFolder() throws InterruptedException {
	
	click_Threedots.click(); 
	Thread.sleep(5000);
	delete_Folder.click();
	Thread.sleep(5000);
	confirm_DeleteFolder.click();
	}

	public void clickExpansionButton() {
		add_Expansion_Btn.click(); 
		
	}
	
	public void clickCollapseButton() {
		add_Collapse_Btn.click(); 
		
	}
	
	public void clickUploadFileButton() {
		add_UploaFile.click();
	
		
	}
	
	public void clickUploadFoler() {
		add_UploadFolder.click(); 
		
	}
	
	public void clickUploadButton() {
		upload_Btn.click(); 
		
	}
	
	public void clickNewFolder() {
		add_NewFolder.click(); 
		
	}
	
	public void enterNewFolder(String FolderName) {
		add_FolderName.sendKeys(FolderName); 
		log.info(FolderName);	
	}
	public void clickCreate() {
		click_CreateBtn.click();
		
	}

	public void clicCancel() {
		click_CancelBtn.click();
		
	}
	
	public void dropFolderssHere() throws AWTException {
		droFolderHere.click();
			
	}
	
	public void dropFilesHere() throws AWTException {
		droFilesHere.click();
			
	}
	
	public void newDocument() {
		newDocument_BTN.click(); 
		
	}
	public void newSpreadsheet() {
		newSpreadsheet_BTN.click(); 
		
	}
	public void pasteFolder() {
		pasteFolder_BTN.click(); 
		
	}
	public void selectfile() {
		selectFile.click(); 
		
	}
	
	public void favorites() {
		favorite_Btn.click(); 
		
	}
	
}
