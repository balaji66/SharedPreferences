package com.durga.balaji66.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEmail,mPassword;
    private Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        initializeListeners();
        if(!new SharedPreferencesStorage(this).isUserLogout())
        {
            startHomeActivity();
        }
    }

    /**
     * This method is for initializing the views
     */
    public void initializeViews() {
        mEmail =findViewById(R.id.editTextEmailId);
        mPassword =findViewById(R.id.editTextPassword);
        mLogin = findViewById(R.id.buttonLogIn);
    }

    /**
     * This method is for initializing the Listeners
     */
    public void initializeListeners() {
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLogIn:
                if(mEmail.getText().toString().equals(""))
                {
                    mEmail.setError("email must not be empty");
                }
                else if(mPassword.getText().toString().equals(""))
                {
                    mPassword.setError("password must not be empty");
                }
                else if(mEmail.getText().toString().equals("email") && mPassword.getText().toString().equals("password")){
                    attemptLoginActivity();
                }

                break;
        }
    }

    /**
     * This method will work when user tyring to login or click the login button.
     */
    public void attemptLoginActivity()
    {
        String email =mEmail.getText().toString();
        String password =mPassword.getText().toString();
        saveLoginDetails(email,password);
        startHomeActivity();

    }

    /**
     * Here we are storing the email and password are in the Shared preferences. Instead of login every time.
     * @param email
     * @param password
     */
    public void saveLoginDetails(String email, String password)
    {
        new SharedPreferencesStorage(this).saveLoginDetails(email,password);
    }

    /**
     * Once user not logged out, user can directly enter into the Home Activity.
     */
    public void startHomeActivity()
    {
        Intent intent =new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

}
