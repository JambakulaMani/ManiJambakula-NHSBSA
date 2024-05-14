package Steps;
import org.openqa.selenium.WebDriver;
import PageObjects.JobSearchPage;
import driver.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class JobSearchStepDefinitions extends BaseClass {
	WebDriver driver;
	JobSearchPage searchjob;
	public BaseClass baseClass;
	@Before
	public void before() {
		baseClass = new BaseClass();
		driver = baseClass.browserSelection();
		searchjob = new JobSearchPage(driver);
	}
	
	
	
	@Given("^I am a jobseeker on NHS Jobs application$")
	public void i_am_a_jobseeker_on_nhs_jobs_website() {
		driver.manage().window().maximize();
	    searchjob.clickCookiesButton();
	}

	@When("^I put my (.*) (.*) preferences into the Search functionality$")
	public void i_put_my_preferences_into_the_search_functionality(String jobTitle, String location) {
		searchjob.enterJobTitle(jobTitle);
		searchjob.enterLocation(location);
		searchjob.clickSearchButton();
		
	}
	
	@Then("I should get a list of jobs which matches my preferences")
	public void i_should_get_a_list_of_jobs_which_matches_my_preferences() {
		String searchResultsPage = driver.getTitle();
		System.out.println("Title of the Page: " + searchResultsPage);

	}
	
	@Then("^sort my search results according to the (.*)$")
	public void sort_my_search_results_with_the_newest_date_posted(String sortselection) throws InterruptedException {
		searchjob.sortByNewestDatePosted(sortselection);
		Thread.sleep(3000);
		driver.quit();
	}
}
