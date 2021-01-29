package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageFactory.PadronLogin;
import pageFactory.PadronCampaignCreator;

public class PadronExample extends BaseTest{

    PadronLogin objLogin;
    PadronCampaignCreator objCampaign;


    /**

     * This test go to http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test
    public void test_Correct_Login(){
    
    	objLogin = new PadronLogin(driver);
    	objCampaign = new PadronCampaignCreator(driver);
    	String strClientName = "CHILDREN HOSPITAL";
    	String strCampaignName = "anything";
    	String strDate = "1/30/2021";
    	String strCampaignNameSelected = "One Day Event Campaign";
    	// open url
    	
    driver.get("https://development.d3rrl4l3d2kbd6.amplifyapp.com/");
    

    //login to application
    

    objLogin.loginPadron("gracie@padrondesign.com", "%Gracie12345678");

    //Select children hospital, campaign, dates,  one day event campaign, select all the services, click on backtrack it
    try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    driver.get("https://development.d3rrl4l3d2kbd6.amplifyapp.com/");
    objCampaign.createCampaign(strClientName, strCampaignName, strDate, strCampaignNameSelected);
    

    //Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    
    }

}