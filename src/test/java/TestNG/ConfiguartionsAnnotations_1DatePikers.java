package TestNG;

import org.testng.annotations.*;

public class ConfiguartionsAnnotations_1DatePikers {

	//@  --> at a Rate

	/*
	 *  Most people create the Test Annotation at Method Level
	 *  TestNG identifies the method by looking up the annotations,
	 *  There fore we can palce the annoations any where in the class.
	 */


	@Test (groups = "Smoke")
	public void test_1BootstrapDatePicker() {
		System.out.println("       (5)  The method-1 :  BootStarp date picker" );

	}

	@Test(groups = {"regression" , "e2e"})
	public void test_2JQeryDatePicker() {
		System.out.println("     (5) The method-2 :  JQeryDatePicker" );

	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("   (4) Execute before Each test Method  ");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("   (4) Execute after Each test Method \n");
	}
	@BeforeClass

	public void beforeClass() {

		System.out.println("   (3) Execute before Class : DatePicker");

	}
	@AfterClass
	public void AfterClass() {

		System.out.println("   (3) Execute after Class : DatePicker");
	}
	
	



}
