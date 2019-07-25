package thebigbang.com.icare.PageObject;

import static android.support.test.espresso.Espresso.pressBack;

/**
 * Created by home on 15/02/17.
 */

public class ServicesPage extends BasePage {

    public UserListPage backtoUserListPage(){
        pressBack();
        return  new UserListPage();
    }
}
