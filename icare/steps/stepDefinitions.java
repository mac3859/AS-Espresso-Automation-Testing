package thebigbang.com.icare.steps;

import android.app.Activity;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import thebigbang.com.icare.Activities.Splash_Screen;
import thebigbang.com.icare.PageObject.BasePage;
import thebigbang.com.icare.PageObject.RegisterPage;
import thebigbang.com.icare.PageObject.ServicesPage;
import thebigbang.com.icare.PageObject.UserListPage;
import thebigbang.com.icare.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by home on 15/02/17.
 */

public class stepDefinitions extends ActivityInstrumentationTestCase2<Splash_Screen> {

    @SuppressWarnings("unused")
    public static final String TAG = stepDefinitions.class.getSimpleName();
    @SuppressWarnings("unused")
    private Context mInstrumentationContext;
    @SuppressWarnings("unused")
    private Context mAppContext;
    private Activity mActivity;

    BasePage basePage = new UserListPage();

//    @Rule
//    public ActivityTestRule<Splash_Screen> mActivityRule = new ActivityTestRule<>(
//            Splash_Screen.class);

    public stepDefinitions() {
        super(Splash_Screen.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mInstrumentationContext = getInstrumentation().getContext();
        mActivity = getActivity(); // Start Activity before each test scenario
    }


    @After
    public void tearDown(){
        onView(withId(R.id.tvUserProfileName)).perform(longClick());
        onView(withText("YES")).perform(click());
    }

    @Then("^I can fill form$")
    public void i_can_fill_form() throws Throwable{
        ((RegisterPage)basePage).fillForm();
    }

    @When("^I open the App$")
    public void I_open_the_App() throws Throwable{
        basePage = ((UserListPage)basePage).addUser();
    }


    @Then("^I can save the form$")
    public void I_can_save_the_form() throws Throwable{
        basePage = ((RegisterPage)basePage).Save();
    }


    @Then("^I can click the user that I just created$")
    public void I_can_click_the_user_that_I_just_created() throws Throwable{
        basePage = ((UserListPage)basePage).clickUser();
    }

    @Then("^I go back to the UserList Screen$")
    public void I_go_back_to_the_UserList_Screen() throws Throwable{
        basePage = ((ServicesPage)basePage).backtoUserListPage();

    }

    @Then("^I can Delete the user$")
    public void I_can_Delete_the_user() throws Throwable{
//        onView(withId(R.id.tvUserProfileName)).perform(longClick());
//        onView(withText("YES")).perform(click());
    }







}
