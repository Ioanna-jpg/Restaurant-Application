package gr.aueb.softeng.view.SignUpPersonel;

import java.util.HashMap;

public interface SignUpPersonelView {
    HashMap<String,String> getChefDetails();
    void showErrorMessage(String title, String message);
    void goBack();
}
