package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.github.sukgu.*;

public class PadronCampaignCreator {

    /**

     * All WebElements are identified by @FindBy annotation

     */
	
    WebDriver driver;
   
    @FindBy(css="span.p-placeholder")
    WebElement clientNameDropdown;
    
    @FindBy(css="li.p-dropdown-item:nth-child(2)")
    WebElement clientNameField;
    
    @FindBy(name="#campaignName")
    WebElement campaignField;
   
    @FindBy(name="#dueDate > input:nth-child(1)")
    WebElement dateField;

    @FindBy(name="#campaignID > span:nth-child(3)")
    WebElement campaignDropdown;
    
    @FindBy(name=".p-dropdown-filter")
    WebElement campaignField2;
    
    @FindBy(name=".p-multiselect-label")
    WebElement serviceDropdown;
    
    @FindBy(name="div.p-checkbox-box:nth-child(2)")
    WebElement serviceAllcheckbox;
    
    @FindBy(name="button.p-button:nth-child(1)")
    WebElement backtrackItButton;
    
    
    public PadronCampaignCreator(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set client name in textbox

    public void setClientName(String strClientName){
        clientNameDropdown.click();
        //clientNameField.sendKeys(strClientName);
        clientNameField.click();
    }

    //Set campaign textbox

    public void setCampaignName(String strCampaignName){
       campaignField.sendKeys(strCampaignName);
    }

    //Set date

    public void setDate(String strDate){
    	dateField.sendKeys(strDate);
    }  
    
    
    //select campaign name
    public void selectCampaignName(String strCampaignNameSelected){
        campaignDropdown.click();
        campaignField2.sendKeys(strCampaignNameSelected);
    }
    
    //Set services
    public void setServices(){
        serviceDropdown.click();
        serviceAllcheckbox.click();
    }
    
    public void clickBacktrackIt(){
        backtrackItButton.click();

    }


    public void createCampaign(String strClientName,String strCampaignName, String strDate, String strCampaignNameSelected){

    	setClientName(strClientName);
    	setCampaignName(strCampaignName);
    	setDate(strDate);
    	selectCampaignName(strCampaignNameSelected);
    	setServices();
    	clickBacktrackIt();

    }

}