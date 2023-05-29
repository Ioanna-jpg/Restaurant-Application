package gr.aueb.softeng.view.Login;

import static java.lang.Thread.sleep;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.io.Serializable;

import gr.aueb.softeng.dao.ChefDAO;
import gr.aueb.softeng.dao.CustomerDAO;
import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.UserDAO;
import gr.aueb.softeng.team08.R;
import gr.aueb.softeng.view.Chef.HomePage.ChefHomePageActivity;
import gr.aueb.softeng.view.Customer.HomePage.CustomerHomePageActivity;
import gr.aueb.softeng.view.Owner.HomePage.OwnerHomePageActivity;
import gr.aueb.softeng.view.SignUp.SignUpCustomer.SignUpCustomerActivity;
import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerActivity;
import gr.aueb.softeng.view.SignUp.SignUpPersonel.SignUpPersonelActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);
        if (savedInstanceState == null){
            Intent intent = getIntent();

        }
        findViewById(R.id.SignUpCustomerButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onSignup();
            }
        });

        findViewById(R.id.SignUpPersonelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.getPresenter().onSignupPersonel();
            }
        });

        findViewById(R.id.SignUpOwnerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().onSignupOwner();
            }
        });

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPresenter().authenticate();

            }
        });
    }

    public String ExtractUsername()
    {
      return ((EditText)findViewById(R.id.usernameText)).getText().toString().trim();

    }
    public String ExtractPassword()
    {
        return ((EditText)findViewById(R.id.passwordText)).getText().toString().trim();
    }
    public void signup(UserDAO userDAO, CustomerDAO custDAO){
        Intent intent = new Intent(LoginActivity.this, SignUpCustomerActivity.class);
/*        intent.putExtra("User DAO", (Serializable) userDAO);
        intent.putExtra("Customer DAO",(Serializable) custDAO);*/
        startActivity(intent);
    }

    public void signupPersonel(UserDAO userDAO, ChefDAO chefDAO) {
        Intent intent = new Intent(LoginActivity.this, SignUpPersonelActivity.class);
/*        intent.putExtra("User DAO", (Serializable) userDAO);
        intent.putExtra("Chef DAO",(Serializable) chefDAO);*/
        startActivity(intent);
    }
    public void signupOwner(UserDAO userDAO, OwnerDAO ownerDAO) {
        Intent intent = new Intent(LoginActivity.this, SignUpOwnerActivity.class);
/*        intent.putExtra("User DAO", (Serializable) userDAO);
        intent.putExtra("Owner DAO",(Serializable) ownerDAO);*/
        startActivity(intent);
    }

    public void redirectToCustomerPage(){
        Intent intent = new Intent(LoginActivity.this, CustomerHomePageActivity.class);
        startActivity(intent);
    }
    public void redirectToChefHomePage(){
        Intent intent = new Intent(LoginActivity.this, ChefHomePageActivity.class);
        startActivity(intent);
    }
    public void redirectToOwnerHomePage(){
        Intent intent = new Intent(LoginActivity.this, OwnerHomePageActivity.class);
        startActivity(intent);
    }

}