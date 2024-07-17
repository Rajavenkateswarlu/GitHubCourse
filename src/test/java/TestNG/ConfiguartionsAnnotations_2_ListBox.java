package TestNG;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

@Test(groups = "regression")
public class ConfiguartionsAnnotations_2_ListBox {
	
	//@  --> at a Rate

		/*
		 *  Most people create the Test Annotation at Method Level
		 *  TestNG identifies the method by looking up the annotations,
		 *  There fore we can palce the annoations any where in the class.
		 *  
		 *  Run the Both class at Same time
		 *  
		 *  BeforeGroup and AfterGroup Purpose of the these 2 annotations is to Execute
		 before and after any test method thats mentioned in a particular group.
		 
		 A suite conatins one or More Test { Name is required attribute }
		 A test contains one more Classes { Class Name }
		 Class name Start With package .
		 Class Contains one or More Methods
		 
		  
		 */
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

		System.out.println("   (3) Execute before Class : List Box");

	}
	@AfterClass
	public void AfterClass() {

		System.out.println("   (3) Execute after Class : List Box");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("  (2) Execute before Each Test ");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("   (2) Execute before Each Test ");
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("  (1) Execute Before the Suite ");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("  (1) Execute After the suite ");
	}

		//@Test
		public void test_3BootstrapListBox() {
			System.out.println("       (5)  The method-3 :  BootStarp ListBox" );

		}

		//@Test
		public void test_4JQeryListBox() {
			System.out.println("     (5) The method-4 :  JQery ListBox" );

		}
		
		@BeforeGroups(groups = { "regression" ,"Smoke"} )
		public void beforeGroups() {
			System.out.println("Execute before Group ");
		}
		@AfterGroups(groups = { "regression" ,"Smoke"} )
		public void afterGroups() {
			System.out.println("Execute after Group ");
		}

}
