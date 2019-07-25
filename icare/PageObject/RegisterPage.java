package thebigbang.com.icare.PageObject;

import android.support.test.espresso.contrib.PickerActions;
import android.widget.DatePicker;

import thebigbang.com.icare.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

/**
 * Created by home on 15/02/17.
 */

public class RegisterPage extends BasePage {
    public void fillForm(){

        //name
        onView(withId(R.id.etName)).perform(typeText("testname"));

        //gender
        onView(withId(R.id.rbMale)).perform(click());

        //Birth Date
        onView(withId(R.id.etDateofBirth)).perform(click());
        onView(withText("OK")).perform(click());

        //Date
        onView(withId(R.id.etDateofBirth)).perform(click());
        onView(withClassName(is(DatePicker.class.getName()))).perform(PickerActions.setDate(1983, 10, 25));
        onView(withText("OK")).perform(click());

        //Blood Group
        onView(withId(R.id.spBloodGroup)).perform(click());
        onView(withText("AB+")).perform(click());

        onView(withId(R.id.spBloodGroup)).perform(click());
        onData(is("O-"))
                .perform(click());

        onView(withId(R.id.spBloodGroup)).perform(click());
        onData(anything())
                .atPosition(4)
                .perform(click());

        //Blood Pressure
        onView(withId(R.id.spBP)).perform(click());
        onView(withText("Low")).perform(click());

        //Weight
        onView(withId(R.id.etWeight)).perform(typeText("83"));
        closeSoftKeyboard();

        //Height
        onView(withId(R.id.etHeight)).perform(typeText("178"));
        closeSoftKeyboard();

        //Email
        onView(withId(R.id.etEmail)).perform(typeText("test@test.co.nz"));
        closeSoftKeyboard();

        //Phone
        onView(withId(R.id.etPhone)).perform(typeText("091234567"));
        closeSoftKeyboard();

    }

    public UserListPage Save(){
        //Save
        onView(withId(R.id.btnSave)).perform(click());
        onView(withText("testname")).check(matches(isDisplayed()));
        return new UserListPage();

    }
}
