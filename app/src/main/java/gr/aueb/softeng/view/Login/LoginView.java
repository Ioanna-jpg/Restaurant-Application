package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.view.View;

public interface LoginView extends View {
    String ExtractUsername();
    String ExtractPassword();
    void signup();
    void signupPersonel();
    void signupOwner();
    void showErrorMessage(String title, String message);
    void redirectToCustomerPage();
   void redirectToChefHomePage();
   void redirectToOwnerHomePage();

}
