package com.POMClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POMInterface.CalculatorPageInterface;
import com.aventstack.extentreports.util.Assert;
import com.baseClass.BaseClass;
import com.pageObjManager.PageObjectManager;


public class CalculatorPage extends BaseClass implements CalculatorPageInterface {

	private WebDriver driver;
	
	public static PageObjectManager instance;
	
	@FindBy(id = age)
    private WebElement currentAge;
	
	@FindBy(id = retirement_age)
    private WebElement retireAge;
	
	@FindBy(xpath = current_income)
    private WebElement currentIncome;	

	@FindBy(xpath = spouse_income)
    private WebElement spouseIncome;

	@FindBy(id = current_savings)
    private WebElement totalSavings;
	
	@FindBy(id = annual_savings)
    private WebElement annualSavings;
	
	@FindBy(id = saving_rate)
    private WebElement increaseRate;
	
	@FindBy(xpath = social_benefits)
    private WebElement socialBenefits;
	
	@FindBy(xpath = marital_status)
    private WebElement maritalStatus;
	
	@FindBy(xpath = marital_status_single)
    private WebElement maritalStatusSingle;
	
	@FindBy(id = social_security)
    private WebElement socialSecurity;
	
	@FindBy(xpath = social_benefitsno)
    private WebElement socialSecurity_No;
		
	@FindBy(xpath = calculator_btn)
    private WebElement calculateBtn;
	
	@FindBy(id = resultMsg)
    private WebElement resultMessage;
	
	@FindBy(xpath = defaultValue)
    private WebElement default_value;
	
	@FindBy(id = addIncome)
    private WebElement addincome;
	
	@FindBy(id = retire_duration)
    private WebElement retireDuration;
	
	@FindBy(xpath = inflation)
    private WebElement inflat;
	
	@FindBy(id = expectInflation)
    private WebElement expectedInflation;
	
	@FindBy(id = retirIncome)
    private WebElement retire_Income;
	
	@FindBy(id = preRetirIncome)
    private WebElement pre_Retire;
	
	@FindBy(id = postRetirIncome)
    private WebElement post_Retire;
	
	@FindBy(xpath = save_Btn)
    private WebElement saveChanges;
		
	  public CalculatorPage(WebDriver driver) {
		  this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	 public void getBrowserUrl() {
		 
	
		browserLaunch(instance.getConfigInstance().getBrowser());
		 launchURL(instance.getConfigInstance().getUrl());
		 
	 }
	 
	 public void getAge() throws IOException {
		   	String currentAgeValue = instance.getUtilityInstance().getCurrentAge();
		    inputValues(currentAge, currentAgeValue);
		}

	 
	 
	 public void getRetireAge() throws IOException {
		 
		 String retirementAgeValue = instance.getUtilityInstance().getRetirementAge();
		 inputValues(retireAge, retirementAgeValue);
		 
	 }
	 
	 public void getAnnualIncome() throws IOException {
		 
		 String currentAnnualIncomeValue = instance.getUtilityInstance().getCurrentAnnualIncome();
		 inputValues(currentIncome, currentAnnualIncomeValue);
		 
	 }
	 
	 public void getSpouseAnnualIncome() throws IOException {
		 
		 String spouseAnnualIncomeValue = instance.getUtilityInstance().getSpouseAnnualIncome();
		 inputValues(spouseIncome, spouseAnnualIncomeValue);
		 
	 }
	 
	 public void getSavingBalance() throws IOException {
		 
		 String currentRetirementSavingsValue = instance.getUtilityInstance().getCurrentRetirementSavings();
		 inputValues(totalSavings, currentRetirementSavingsValue);
		 
	 }
	 
	 public void getAnnualSaving() throws IOException {
		 
		 String currentContrValue = instance.getUtilityInstance().getCurrentRetirementContribution();
		 inputValues(annualSavings, currentContrValue);
		 
	 }
	 
	 public void getRate() throws IOException {
		 
		 String annualContrIncr = instance.getUtilityInstance().getAnnualRetirementContributionIncrease();
		 inputValues(increaseRate, annualContrIncr);
		 
	 }
	 
	 
	 public void getSocialBenefitsYes() {
		 
		 clickTheElement(driver, socialBenefits);
		 
	 }
	 
	 public void getSocialBenefitsNo() {
		 
		  if (!socialSecurity_No.isSelected()) {
			  socialSecurity_No.click();
		    }
		 
	 }
	  
	 public void getMaritalStatus() throws IOException {
		 
		 
		 if(instance.getUtilityInstance().getRelationshipStatus().equalsIgnoreCase("married")) {
		 
			 clickTheElement(driver, maritalStatus);
			 
		 }else if(instance.getUtilityInstance().getSocialSecurityIncome().equalsIgnoreCase("single")) {
			 
			 clickTheElement(driver, maritalStatusSingle);
			 
		 }else {
			 
			 System.out.println("Invalid");
		 }
		 
	 }
	 
	 public void getSecurityOverride() throws IOException {
		 
		 String socialSecOver = instance.getUtilityInstance().getSocialSecurityOverride();
		 inputValues(socialSecurity, socialSecOver);
		 
	 }
	 
	 public void getClickCalculator() throws IOException {
		 
		 clickTheElement(driver, calculateBtn);
		 
	 }
	 
 	public void getResultMessage() throws IOException {
		 
 	     System.out.println("Details updated Successfully");
		
	 }
 	
 	public void clickDefaultValue() {
		 
 		clickTheElement(driver, default_value);
		
	 }
 	
 	public void getAddIncome() throws IOException {

 		String add_Income = instance.getUtilityInstance().getAdditionalIncome();
		 inputValues(addincome, add_Income);
		 
		
	 }
 	
 	public void getNoYrs() throws IOException {

 		String noYrs = instance.getUtilityInstance().getNoYrs();
		 inputValues(retireDuration, noYrs);
		 
		
	 }
 	
 	public void getInflation() throws IOException {

 		clickTheElement(driver, inflat);
 		
	 }

 	public void getExpectedInflation() throws IOException {

 		String expInflation = instance.getUtilityInstance().getExpectedInflation();
 		inputValues(expectedInflation, expInflation);
 		
	 }
 
 	
 	public void getFinalIncome() throws IOException {

 		String finalIncome = instance.getUtilityInstance().getFinalIncome();
		 inputValues(retire_Income, finalIncome);
		 
		
	 }
 	
 	public void getPreRetire() throws IOException {

 		String preRetire = instance.getUtilityInstance().getPreRetire();
		 inputValues(pre_Retire, preRetire);
		 
		
	 }
 	
	
 	public void getPostRetireInv() throws IOException {

 		String preRetire = instance.getUtilityInstance().getPostRetireInv();
		 inputValues(post_Retire, preRetire);
		 
		
		
	 }
 	
 	public void clickSave() throws IOException {
 		
 		
 		clickTheElement(driver, saveChanges);
		
	 }
 	
 	

}
