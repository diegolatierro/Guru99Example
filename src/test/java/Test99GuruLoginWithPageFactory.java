package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageFactory.Guru99HomePage;
import pageFactory.Guru99Login;

public class Test99GuruLoginWithPageFactory extends BaseTest{

    Guru99Login objLogin;

    Guru99HomePage objHomePage; 

    /**

     * This test go to http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test
    public void test_Home_Page_Appear_Correct(){
    // open url
    	
    driver.get("http://demo.guru99.com/V4/");

    //Create Login Page object

    objLogin = new Guru99Login(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application

    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page

    objHomePage = new Guru99HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    
    }

}