# [Appium](http://appium.io/docs/en/about-appium/intro/?lang=en)
![](https://avatars3.githubusercontent.com/u/3221291?v=3&s=200)
> Appium is an open source mobile automation testing tool
> APPIUM has framework or wrapper that translate Selenium Webdriver commands into UIAutomation (iOS) or UIAutomator (Android) commands depending on the device type, it can automate various types of apps.
- Native Apps                               
- Hybrid Apps
- Mobile Web Apps

# Appium System Requirements

- Windows

- Eclipse IDE
- JDK 7+
- Appium Desktop

       *downlaod appium.exe from here: https://github.com/appium/appium-desktop/releases/*
- Android Studio

       *downlaod appium.exe from here:https://developer.android.com/studio*

### Environment Variable Setup for JAVA and ANDROID

> JAVA HOME: C:\Program Files\Java\jdk1.8.0_191

> ANDROID HOME: C:\Prashanth\Softwares\android-sdk

> Platform-Tools: C:\Prashanth\Softwares\android-sdk\platform-tools

*to set environment variables goto System settings > Environment Variables > update the paths*

- ADT Pulgin for Eclipse

  - Start Eclipse, then select **Help** > **Install New Software**.
  - Click **Add**, in the top-right corner.
  - In the Add Repository dialog that appears, enter "**ADT Plugin**" for the Name and the following URL for the Location: **https://dl-ssl.google.com/android/eclipse/**
  - Click **OK**.
  - If you have trouble acquiring the plugin, try using "**http**" in the Location URL, instead of "**https**" (https is preferred for security reasons).
  - In the Available Software dialog, select the **checkbox** next to Developer Tools and click **Next**.
  - In the next window, you'll see a list of the tools to be downloaded. Click **Next**.
  - Read and **accept** the license agreements, then click **Finish**.
  - If you get a security warning saying that the authenticity or validity of the software can't be established, click **OK**.
  - When the installation completes, **restart** Eclipse.

# Other Plugins and Tools:

- [TestNg](https://testng.org/doc/documentation-main.html)
- [Maven](https://maven.apache.org/what-is-maven.html)
- [Testng.XML](https://testng.org/doc/documentation-main.html#testng-xml)
- [JXL](http://jexcelapi.sourceforge.net/)
- [Extent Libraries](http://extentreports.com/docs/versions/2/java/)
- [Jenkins CI/CD](https://jenkins.io/doc/)

### POM.XML Required Dependencies:

```html
<dependencies>
	<!-- dependency for extent reports to create an html file for execution report -->
		<dependency>
			<groupId>com.relevantcodes</groupId>
			<artifactId>extentreports</artifactId>
			<version>2.40.2</version>
    </dependency>
		<!-- dependency for testng plugin -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.8</version>
		</dependency>
		<!-- dependency for Appium Java Client -->
		<dependency>
			<groupId>io.appium</groupId>
			<artifactId>java-client</artifactId>
			<version>4.1.2</version>
		</dependency>
		<!-- dependency for JXL API to read data from Excel -->
		<dependency>
			<groupId>net.sourceforge.jexcelapi</groupId>
			<artifactId>jxl</artifactId>
			<version>2.6.3</version>
		</dependency>
		
This Dependencies used in Mobile Automation Testing Project
```

# Commands
## Find Element
Search for an element on the page
#### Example of Usage

> driver.findElement(By.id("resourceID"));

> driver.findElement(By.ClassName("SomeClassName"));
  
#### Description: 
Get the first element that matches a [locator strategy](http://appium.io/docs/en/commands/element/find-elements/index.html#selector-strategies)

## Find Elements
Search for multiple elements
#### Example of Usage

> List<MobileElement> elementsOne = driver.findElements(By.id("resourceID"));

> List<MobileElement> elementsTwo =  driver.findElements.(By.ClassName("SomeClassName"));
  
#### Description: 
Get a list of elements that match the [locator strategy](http://appium.io/docs/en/commands/element/find-elements/index.html#selector-strategies)

## Click
Click element at its center point.

#### Example Usage

> driver.findElement(By.Id("SomeId")).click();

#### Description

Clicks element at its center point. If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.

## Send Keys
Send a sequence of key strokes to an element

#### Example Usage

> driver.findElementBy(.Id("SomeAccessibilityID")).sendKeys("Hello world!");

#### Description
Any UTF-8 character may be specified, however, if the server does not support native key events, it should simulate key strokes for a standard US keyboard layout. The Unicode Private Use Area code points, 0xE000-0xF8FF, are used to represent pressable, non-text keys (see table below). (See Unicode document for information on Unicode characters)

## Clear Element
Clear an element's value

#### Example Usage

> driver.findElement(By.Id("SomeAccessibilityID")).clear();

#### Description
it is to clear the text from text box if available

## Get Current Context

Get the current context in which Appium is running

#### Example Usage

> String context = driver.getContext();

#### Description

Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be:

> iOS - WEBVIEW_<id>
> Android - WEBVIEW_<package name>
> For information on contexts, see Appium's [hybrid automation docs](http://appium.io/docs/en/writing-running-appium/web/hybrid/index.html).

 *other reusable methods are available under BaseClase in utils package inside the project*

# Page Object Model Structure

## Objects
here we are careating locators as page object format
```java
   /**	 
    * This Object is to find Hamburger Menu locator in Home Page
	*/
	public By HamburgerMenu = By.xpath("//i[text()='menu']");
	/**
	 * This Object is to find Flowers field locator Under Menu
	 */
	public By menu_Flowers = By.xpath("//a[text()='Flowers' and @tabindex]");
	/**
	 * This Object is to find Flowers By Type field locator Under Flowers
	 * field(Hamburger Menu)
	 */
	public By menu_FlowersByTypes = By.xpath("//a[text()='Flowers By Type']");
```
## Test Steps
by using page objects we are writing teststeps

```java
public void clickFlowers() throws Exception {
    //to click on Hamburger menu
	click(locator.HamburgerMenu);
	//to click on Flowers in Menu Fields
	click(locator.menu_Flowers);
	//to click on Flowers By Types under Flowers
	click(locator.menu_FlowersByTypes);
		}
```
## TestSuite
will inherit Base Class, Locators and TestSeps to execute the test cases

```java
@Test(priority = 1, enabled = true, description = "verify the functionality of selecting Flowers category")
	public void regression_01() throws Exception
	{
		steps.clickFlowers();
	}
```
# Launch the App using [Desired Capabilities](http://appium.io/docs/en/writing-running-appium/caps/)

> Desired Capabilities are keys and values encoded in a JSON object, sent by Appium clients to the server when a new automation session is requested. They tell the Appium drivers all kinds of important things about how you want your test to work. Each Appium client builds capabilities in a way specific to the client's language, but at the end of the day, they are sent over to Appium as JSON objects.
Some important capabilities
 are demonstrated in the following example:

```java
   DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Moto");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "");
		dc.setCapability("appPackage", "PAKAGE NAME");
		dc.setCapability("appActivity", "LAUNCHABLE ACTIVITY");
		dc.setCapability("autoAcceptAlerts", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("automationName", "UiAUtomator2");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, dc);
		wait = new WebDriverWait(driver, 20);
```

# TestNG Configurations:

> we are using testng framework as executable class using different types of annotations

### Configuration information for a TestNG class: 

* **@BeforeSuite**: The annotated method will be run before all tests in this suite have run.
* **@AfterSuite**: The annotated method will be run after all tests in this suite have run. 
* **@BeforeTest**: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run. 
* **@AfterTest**: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. 
* **@BeforeClass**: The annotated method will be run before the first test method in the current class is invoked. 
* **@AfterClass**: The annotated method will be run after all the test methods in the current class have been run. 
* **@BeforeMethod**: The annotated method will be run before each test method. 
* **@AfterMethod**: The annotated method will be run after each test method.

### Behaviour of annotations in superclass of a TestNG class

The annotations above will also be honored (inherited) when placed on a superclass of a TestNG class. This is useful for example to centralize test setup for multiple test classes in a common superclass.

In that case, TestNG guarantees that the "@Before" methods are executed in inheritance order (highest superclass first, then going down the inheritance chain), and the "@After" methods in reverse order (going up the inheritance chain).

###  @DataProvider

> Marks a method as supplying data for a test method. The annotated method must return an Object[][] where each Object[] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.

### @Test

> it should Marks a class or a method as part of the test.

# testng.xml
we can invoke TestNG With a testng.xml file
Here is an example testng.xml file:
```html
  
<suite name="TestSuite" >
  <test name="MobileSiteProd" >
    <classes>
    <!-- PackageName.ClassName -->
       <class name="TestSuite.ExecuteTest" />
    </classes>
  </test>
</suite>
```

# Running Tests

here we have multiple options to run our test cases

> 1. Testng.XML 
> 2. Testng Class(Test Suite Class which has @Test Annotations)
> 3. POM.xml(A Project Object Model or POM is the fundamental unit of work. It is an XML file that contains information about the project and configuration details used by Maven to build the project)



# Screenshots

we are cresting screenshots with unique ID using webdriver below is the code
```java
public static String createScreenshot(WebDriver driver)
	{
	//specify the location where to store the images we are using .html type to attach the screenshots to Extent reports
		 String reportLocation = "C:\\Users\\Administrator\\Desktop\\FNPSchdeuler\\apache-tomcat-7.0.84\\webapps\\ROOT\\FnPExtentReports\\GiftsMobileIndia.html";
		 String imageLocation = "images/";
		//A class that represents an immutable universally unique identifier (UUID).A UUID represents a 128-bit value. 
		    UUID uuid = UUID.randomUUID();
		    // generate screenshot as a file object
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    try {
		        // copy file object to designated location
		        FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
		    } catch (IOException e) {
		        System.out.println("Error while generating screenshot:\n" + e.toString());
		    }
		    return reportLocation + uuid + ".png";
	}
```
> 


# Reports

for our tests we are using **Extent Reports** to genearte the effective test report
**Extent Reports**:
> Extent Report is a HTML reporting library for Selenium WebDriver for Java which is to a generate an excellent execution reports. 

> We can use this tool within our TestNG automation framework.and it is most widely used reporting library for Selenium test automation.

##### Eaxmaple Code:

```java
 
    public static ExtentReports extent;
	public static ExtentTest test;
	     public void extentReportTests(){
 
           // Create object of extent report and specify the Class name in get method
           extentReport = "C:\\Prashanth\\Reports\\TestSuite.html";
           extent = new ExtentReports(extentReport, true);
           // Start Test
           test=extent.startTest("Verify Page Title");
           // Start browser
           WebDriver driver=new FirefoxDriver();
           driver.manage().window().maximize();
           extent.log(LogStatus.INFO, "Browser started");
           // Open application
           driver.get("https://www.google.com/");
           test.log(LogStatus.INFO, "Navigated to google");
           // get title
           String title=driver.getTitle();
           test.log(LogStatus.INFO, "Get the current title");
           // Verify title
            Assert.assertTrue(title.contains("Google"));
            extent.log(LogStatus.PASS, "Title verified");
            // Close application
            driver.quit();
            extent.log(LogStatus.INFO, "Browser closed");
            // close report
            extent.endTest();
            driver.flush();
     }
 ```
 
