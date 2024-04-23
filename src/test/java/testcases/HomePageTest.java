	package testcases;

	import base.TestBase;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import pages.HomePage;

	public class HomePageTest extends TestBase {
		HomePage homePage;

		//test cases should be separated -- independent with each other
		//before each test case -- launch the browser
		//@test -- execute test case
		//after each test case -- close the browser

		@BeforeMethod
		public void setUp() {
			initialization();
			homePage = new HomePage();
			homePage.acceptCookies();
		}

		@Test
		public void verifyHomePageTitleTest(){
			String homePageTitle = homePage.verifyHomePageTitle();
			Assert.assertTrue(homePageTitle.contains( "Ønskeskyen"));
		}

		@Test
			public void verifyFollowersTest(){
			homePage.clickOnBrands();
			homePage.clickOnChild();
			homePage.clickPlysdyr();
			Assert.assertEquals(homePage.verifyHomePageTitle(),"Plysdyr.dk");
			Assert.assertEquals(homePage.followersCount(),"4 følgere");
		}

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}

	}
