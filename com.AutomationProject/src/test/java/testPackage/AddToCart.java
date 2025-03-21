package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListeners.class)
public class AddToCart extends BaseTest {
	
	@Test
	public void addToCartMethod()  {
		WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartphoneAddToCartButton().click();
		
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sp.getSmartphoneCartProduct().isDisplayed(),true, "Product is not added to cart");
		sa.assertAll();
		//boolean result = sp.getSmartphoneCartProduct().isDisplayed();
		//System.out.println(result);
		
		//if(sp.getSmartphoneCartProduct().isDisplayed())
		//{
			//System.out.println("Product is added to cart");
		//}
		//else
		//{
			//System.out.println("Product is not added to cart");
		//}
		
		// RemoveProduct rp = new RemoveProduct(driver);
		 
		// rp.getRemoveCart().click();
		 
		 //UpdateShoppingCart usc = new UpdateShoppingCart(driver);
		 
		 //usc.getUpdateShoppingCartButton().click();
	}

}
