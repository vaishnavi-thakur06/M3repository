package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import genericLibrary.SelectUtility;

public class CheckOutPage extends BaseTest
{

	@FindBy(id="BillingNewAddress_CountryId") private WebElement countryNameDD;
	@FindBy(id="BillingNewAddress_City") private WebElement cityNameTB;
	@FindBy(id="BillingNewAddress_Address1") private WebElement address1NameTB;
	@FindBy(id="BillingNewAddress_ZipPostalCode") private WebElement pincodeTB;
	@FindBy(id="BillingNewAddress_PhoneNumber") private WebElement phoneNumberTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']") private WebElement billingAddressContinueButton;	
	@FindBy(xpath ="//input[@onclick='Shipping.save()']") private WebElement shippingAddressContinueButton;
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']") private WebElement shippingMethodContinueButton;
	@FindBy(xpath= "//input[@onclick='PaymentMethod.save()']") private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']") private WebElement paymentInfoContinueButton;
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']") private WebElement confirmButton;
	@FindBy(xpath="//strong[text()='Your order has been successfully processed!']") private WebElement orderProcessedText;
	@FindBy(id="billing-address-select") private WebElement billingAddressOldAddressDD;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCountryNameDD() {
		return countryNameDD;
	}

	public WebElement getCityNameTB() {
		return cityNameTB;
	}

	public WebElement getAddress1NameTB() {
		return address1NameTB;
	}

	public WebElement getPincodeTB() {
		return pincodeTB;
	}

	public WebElement getPhoneNumberTB() {
		return phoneNumberTB;
	}

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getOrderProcessedText() {
		return orderProcessedText;
	}
	
	public WebElement getBillingAddressOldAddressDD() {
		return billingAddressOldAddressDD;
	}

	//operational Method
	public void buyProduct() throws EncryptedDocumentException, IOException
	{
		SelectUtility su = new SelectUtility();
		try 
		{
				if(billingAddressOldAddressDD.isDisplayed()== true)
				{
					su.selectByVisibleTextMethod(billingAddressOldAddressDD, "New Address");
				}
		}
		catch(Exception e)
		{
			su.selectByVisibleTextMethod(countryNameDD, "India");
		}
		//billingAddressOldAddressDD.isDisplayed()?su.selectByVisibleTextMethod(billingAddressOldAddressDD, "New Address"):su.selectByVisibleTextMethod(countryNameDD, "India");
		
		su.selectByVisibleTextMethod(countryNameDD, "India");
		Flib flib = new Flib();
		int rn = flib.randomNumber();
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 1);
		long pin = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		long phone = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
		String phoneNo = phone+""+rn;
		
		cityNameTB.sendKeys(city);
		address1NameTB.sendKeys(address1);
		pincodeTB.sendKeys(String.valueOf(pin));
		phoneNumberTB.sendKeys(String.valueOf(phoneNo));
		billingAddressContinueButton.click();
		
		shippingAddressContinueButton.click();
		shippingMethodContinueButton.click();
		paymentMethodContinueButton.click();
		paymentInfoContinueButton.click();
		confirmButton.click();
		
		  SoftAssert sa = new SoftAssert();
		  sa.assertEquals(orderProcessedText.isDisplayed(), true, "Order is not placed!!!");
		  sa.assertAll();
	}
	
	
}
