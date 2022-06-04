package RandomCalculator;

import java.util.concurrent.TimeUnit;

import ObjectRepository.ObjectRepo;
import ShopSearch.ChromeDriver;
import ShopSearch.Given;
import ShopSearch.WebDriver;

public class CalculateAssignments {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		ObjectRepo objectrepo= new ObjectRepo(driver);
		
	@Given("^user has navigate to random calculator$") 
	public void user_has_navigate_to_random_calculator() throws Throwable
	{
		driver.get("https://www.graphpad.com/quickcalcs/randomize1/");
	}
	
	@Then("^user provide {arg} as assign, {arg} as subjects to each of, {arg} as repeat$")
	public void user_provide_assign_subjectstoeachof_repeat (assign, subjecttoeachof, repeat) throws Throwable
	{
		//Select assign, subject to each of, repeat
		objectrepo.typeAssignValue(assign);
		objectrepo.selectSubjecToEachOf(subjecttoeachof);
		objectrepo.selectRepeat(repeat);
	}
	
	@When("^user user click on Doit button$") 
	public void user_click_on_doit button() throws Throwable
	{
		 //Click on do it button
		objectrepo.clickDoitButton();
	}	
	
	@Then("^user verify the number of individuals {arg} and assignments {arg}$")
	public void user_verify_the_number_of_individuals_and_assignments (individuals, assignments) throws Throwable
	{
		//Verify the number of assignments
		softAssert.assertTrue(objectrepo.countResultRecords()=individuals+1);
		
		//Verify the 1st column values
		if (objectrepo.validateFirstColumnRecords==false) {
			System.out.println("The records in the 1st column are NOT having the proper number of subjects and values");
		}
		else {
			System.out.println("The records in the 1st column are having the proper number of subjects and values");
		}
		
		//Verify the 2nd column values
		if (objectrepo.validateSecondColumnRecords (assignments)==false) {
			System.out.println("The records in the 2nd column are NOT having the proper assigned group values");
		}
		else {
			System.out.println("The records in the 2nd column are having the proper assigned group values");
		}
	}		
	driver.close();
	}
}
