package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileBy;
import utils.BaseClass;

public class Locators extends BaseClass{
	

public By hambergerMenu = By.xpath("//android.widget.ImageView[@content-desc='Open navigation menu']");

public By inviteFriends = By.xpath("//android.widget.TextView[@text='Invite Friends']");

public By textFields = By.className("android.widget.TextView");
public By search = By.className("android.widget.EditText");
public By contactHello = By.xpath("//android.widget.TextView[@text='HelloThere']");
public By contactUIa = By.xpath("//android.widget.TextView[@text='UIDAI']");
public By backArrow = By.xpath("//android.widget.ImageView[@content-desc='Go back']");

/**
 * <h1> this method is to perform click and scroll actions</h1?
 * <p> click on hamburger menu --> click on invite Friends --> perform Scroll and click on a contact
 * @author Prashanth
 * @throws Exception
 */
public void clickAndScroll() throws Exception{
	click(hambergerMenu);
	printAvailableElementsText(textFields);
	click(inviteFriends);
	waitForElement(search, 5);
	getattributevalue(search, "content-desc");
	wait(2000);
	UiSCrollableByIdText("android:id/content", "HelloThere");
	click(contactHello);
	
}
public By contactsMenu = By.xpath("//android.widget.TextView[@text='Contacts']");
public By sorting = By.xpath("//android.widget.ImageView[@content-desc='Change sorting']");
/**
 * <h1> this method is verify sorting order</h1?
 * <p> click on contacts and verify sort oprions
 * @author Prashanth
 * @throws Exception
 */
public void sorting() throws Exception{
	click(backArrow);
	click(hambergerMenu);
	click(contactsMenu);
	printAvailableElementsText(textFields);
	click(contactsMenu);
	printAvailableElementsText(textFields);
	
}

}
