package com.master_module;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasePackage.TestBase;
import com.UtilitiesClasses.Constants;
import com.UtilitiesClasses.ExpectedValue;

import comfssdomainpageobjects.SidebarObjects;
import comfssdomainpageobjects.SuperAdminBranchPageObject;
import comfssdomainpageobjects.SuperAdminCompanyCardPageObjects;
import comfssdomainpageobjects.SuperAdminSignInpagePageObjects;


public class SuperadminModuleTestScripts extends TestBase{
	
	public SuperAdminSignInpagePageObjects superadminsigninpage ;
    public SuperAdminCompanyCardPageObjects superadmincompany;
    public SuperAdminBranchPageObject SuperadminBranchcard;
   
    
    Logger log = Logger.getLogger(SuperadminModuleTestScripts.class);
    
        //superadmin login method
        public void SuperadminLogin() {
            superadminsigninpage= new SuperAdminSignInpagePageObjects(driver);
            superadminsigninpage.navigateUrl(Constants.URL) ; 
            superadminsigninpage.enterSuperAdminUserId(Constants.superadminUsername); 
            superadminsigninpage.enterSuperAdminuserPassword(Constants.superadminPassword); 
            superadminsigninpage.clickOnSuperAdminLoginButton();     
    }
      //superadmin login test case
        @Test(priority=0,description="This testcase verifies super admin login functionality",enabled=true)
        public void verifySuperAdminLoginFunctionality() throws InterruptedException {
            SuperadminLogin(); 
            Assert.assertEquals(superadminsigninpage.isUserNameDisplayed(),Constants.ExpectedUsernameText);   
            Assert.assertEquals(superadminsigninpage.isUserNameDisplayed(),Constants.ExpectedUsernameText); 
            Assert.assertTrue(superadminsigninpage.isUsernameTextboxDisplayed(),"The Username Textbox is not Displayed on Signin Page.");
            Assert.assertTrue(superadminsigninpage.isPasswordTextboxDisplayed(),"The Password Textbox is not Displayed on Signin Page.");
            Assert.assertTrue(superadminsigninpage.isRememberMeCheackboxSelected(),"The Remember Me Cheackbox is not Selected on Signin Page.");
            Assert.assertTrue(superadminsigninpage.isLOGINButtonEnabled(),"The LOGIN Button is not Enabled on Signin Page.");
        }
        
        @Test(priority=1,description="This testcase verifies user able to create company",enabled=true)
        public void verifycreatenewcompany() throws InterruptedException{
            SuperadminLogin();
            //SidebarObjects superadmin_sidebar = new SidebarObjects(driver);
            //superadmin_sidebar.clickOnsuperadminsidebar();
            superadmincompany =new SuperAdminCompanyCardPageObjects(driver);
            superadmincompany.clickOnsuperadminsidebar1();
            superadmincompany.clickOnCompanyCard();
            superadmincompany.clickOnCreateNew();
            superadmincompany.enterCreatenewCompanyDetails(Constants.CompanyName, Constants.Email,Constants.MobileNumber,Constants.PinCode,Constants.StateName,Constants.Countryname,Constants.WebsiteName,Constants.Location,Constants.FAXNumber,Constants.FIATACode,Constants.IATACode,Constants.VATNumber,Constants.GSTNumber,Constants.EnterDescription,Constants.BankAccountNumber,Constants.EnterAccountHolder,Constants.BankName,Constants.BankBranch,Constants.BeneficiaryName,Constants.IFSCODE);  
            Assert.assertEquals(ExpectedValue.CompanyName,superadmincompany.validateCreateNewButtonEnable());
            Assert.assertEquals(superadmincompany.validateCreateNewButtonDisplay( ), "The Create New Button is not Displayed on create new  Page" );
            Assert.assertEquals(superadmincompany.validateCreateNewButtonEnable( ), "The Create New ButtonEnable is not Displayed on create new  Page" );
            Assert.assertEquals(superadmincompany.validateSaveButtonDisplay( ), "The Save Button is not Displayed on create new  Page" );
        }
        
        @Test(priority=2,description="This test case verifies user able to edit,view,update,cancel created company",enabled=true)
        public void verifyCreatedCompanyEditUpdateCancelViewDelete()
        {
            SuperadminLogin();
            superadmincompany =new SuperAdminCompanyCardPageObjects(driver);
            superadmincompany.clickOnsuperadminsidebar1();
            superadmincompany.clickOnCompanyCard();
            superadmincompany.clickonExportAsbutton();
            superadmincompany.clickonExcelbutton();
            superadmincompany.clickonCSVbutton();
            superadmincompany.clickonInactiveCompany();
            superadmincompany.clickonActiveCompany();
            superadmincompany.clickonCompany();
            superadmincompany.clickonEditCompany(); 
            superadmincompany.ClickonEditCompanyOKButton();
            superadmincompany.Enter_Description(Constants.Enterdescription);
            superadmincompany.clickonUpdateButton();
            superadmincompany.clickonCancelButton();
            superadmincompany.clickonActiveCompany();
            superadmincompany.clickonCompany();
            superadmincompany.clickonViewCompany();
            Assert.assertEquals(superadmincompany.isViewCompanytDisplayed(),"The View Company  Button is not Displayed on create new  Page" );
            Assert.assertEquals(superadmincompany.isViewCompanyOKButtonDisplay(),"The View Company OK Button is not Displayed on create new  Page" ); 
        }
        
        @Test(priority=3,description="This test case verifies user able to create new branch in created company and able to view,edit,update,cancel",enabled=true)
        public void verifySuperAdminCreateNewViewEditUpdateCancelBranch() throws InterruptedException
        {
            SuperadminLogin();
            superadmincompany =new SuperAdminCompanyCardPageObjects(driver);
            superadmincompany.clickOnsuperadminsidebar1();
            superadmincompany.clickOnCompanyCard();
            superadmincompany.clickonActiveCompany();
            superadmincompany.clickonCompany();
            superadmincompany.clickonSettingCompany();
            superadmincompany.clickonSettingCompanyOkButton();
            SuperadminBranchcard = new SuperAdminBranchPageObject (driver);
            SuperadminBranchcard.clickonBranchCard();
            SuperadminBranchcard.CreateNewBranch();
            SuperadminBranchcard.enterCreatenewBranchDetails(Constants.EnterBranchName,Constants.Location,Constants.EnterbranchCode,Constants.Enteremail,Constants.EntergstNumber);
            SuperadminBranchcard.enterBranchAddressDetails(Constants.EnterAddress1,Constants.EnterAddress2, Constants.EnterPhoneNo, Constants.Entercity, Constants.Entercity, Constants.Enterdistrict);
             Thread.sleep(2000);
             SuperadminBranchcard.clickonExportAsbutton();
             SuperadminBranchcard.clickonExcelbutton();
             SuperadminBranchcard.clickonCSVbutton();
             SuperadminBranchcard.clickonselect_branch();
             SuperadminBranchcard.clickOnViewIcon();
             SuperadminBranchcard.ClickonokButton();
             SuperadminBranchcard.clickOnEditIcon();
             SuperadminBranchcard.Enter_branchCode1(Constants.EnterbranchCode);
             SuperadminBranchcard.clickonUpdateButton();
             Assert.assertEquals(ExpectedValue.CreateNewBranch,SuperadminBranchcard.isCreateNewButtonTextDisplayed());
             Assert.assertEquals(ExpectedValue.Location,SuperadminBranchcard.isBranchLocationTextDisplayed());
             Assert.assertEquals(ExpectedValue.branchCode,SuperadminBranchcard.isBranchCodeTextDisplayed());
             Assert.assertEquals(ExpectedValue.gstState,SuperadminBranchcard.isBranchGSTstateTextDisplayed());
             Assert.assertEquals(ExpectedValue.SubmitButtont,SuperadminBranchcard.isSubmitButtonTextDisplayed() );
             Assert.assertEquals(ExpectedValue.CreatedSuccessfull,SuperadminBranchcard.isCreatedSuccessfullyMessageDisplayed());
             
             
             
        }}