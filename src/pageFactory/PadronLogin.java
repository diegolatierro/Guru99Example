package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.github.sukgu.*;

public class PadronLogin {

    /**

     * All WebElements are identified by @FindBy annotation

     */
	
    WebDriver driver;
    public WebElement expand_shadow_element(WebElement element)
    {
        WebElement shadow_root = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
        return shadow_root;
    }
    Shadow shadow = new Shadow(driver);

    public PadronLogin(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){
        WebElement root1 = driver.findElement(By.cssSelector("amplify-sign-in.hydrated"));
        WebElement shadow_root1 = expand_shadow_element(root1);
        
        WebElement root2 = shadow_root1.findElement(By.cssSelector("amplify-auth-fields.hydrated"));
        WebElement shadow_root2 = expand_shadow_element(root2);
        
        WebElement root3 = shadow_root2.findElement(By.cssSelector("amplify-email-field.hydrated"));
        WebElement shadow_root3 = expand_shadow_element(root3);
        
        WebElement root4 = shadow_root3.findElement(By.cssSelector(".hydrated"));
        WebElement shadow_root4 = expand_shadow_element(root4);
        
        WebElement emailInput = shadow_root4.findElement(By.cssSelector("input"));
        emailInput.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){
        WebElement root1 = driver.findElement(By.cssSelector("amplify-sign-in.hydrated"));
        WebElement shadow_root1 = expand_shadow_element(root1);
        
        WebElement root2 = shadow_root1.findElement(By.cssSelector("amplify-auth-fields.hydrated"));
        WebElement shadow_root2 = expand_shadow_element(root2);
        
        WebElement root3 = shadow_root2.findElement(By.cssSelector("amplify-password-field.hydrated"));
        WebElement shadow_root3 = expand_shadow_element(root3);
        
        WebElement root4 = shadow_root3.findElement(By.cssSelector(".hydrated"));
        WebElement shadow_root4 = expand_shadow_element(root4);
        
        WebElement passwordInput = shadow_root4.findElement(By.cssSelector("input"));
        passwordInput.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){
    	 WebElement root1 = driver.findElement(By.cssSelector("amplify-sign-in.hydrated"));
         WebElement shadow_root1 = expand_shadow_element(root1);
         
         WebElement root2 = shadow_root1.findElement(By.cssSelector("amplify-form-section.hydrated"));
         WebElement shadow_root2 = expand_shadow_element(root2);
         
         WebElement root3 = shadow_root2.findElement(By.cssSelector("amplify-button.hydrated"));
         WebElement shadow_root3 = expand_shadow_element(root3);
         
         //WebElement signinButton = shadow_root2.findElement(By.cssSelector("amplify-button.hydrated"));
         WebElement signinButton = shadow_root3.findElement(By.cssSelector(".button"));
         
         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", signinButton);
         
    }  

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginPadron(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();           

    }

}