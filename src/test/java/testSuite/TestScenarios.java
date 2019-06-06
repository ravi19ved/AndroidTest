package testSuite;

import org.testng.annotations.Test;

import pageObjects.Locators;
import utils.BaseClass;

public class TestScenarios extends BaseClass{

	Locators execute= new Locators();
	@Test(description ="verify click and scroll/action actions")
	public void testCae1() throws Exception{
		System.out.println("Launched");
		execute.clickAndScroll();
	} 
	
	@Test(description ="verify click and scroll/action actions")
	public void testCase2() throws Exception{
		System.out.println("Launched");
		execute.sorting();
	} 
}
