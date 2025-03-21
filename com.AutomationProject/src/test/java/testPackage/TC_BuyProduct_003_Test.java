package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomPackage.CheckOutPage;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListeners.class)
public class TC_BuyProduct_003_Test extends BaseTest {
  @Test
  public void buyProductMethod() throws EncryptedDocumentException, IOException 
  {
	    WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartphoneAddToCartButton().click();
		
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getSmaertphoneCheckbox().click();
		
		sp.getTermsOfServicesCheckbox().click();
		sp.getCheckoutButton().click();
		
		CheckOutPage cp = new CheckOutPage(driver);
		cp.buyProduct();
		}
}
