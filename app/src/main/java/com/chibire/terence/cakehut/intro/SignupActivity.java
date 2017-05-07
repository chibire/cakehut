package com.chibire.terence.cakehut.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chibire.terence.cakehut.R;

/**
 * Created by root on 4/14/17.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    Button register;
    TextView signin;

    EditText edt_Name, edt_Password, edt_RePassword, edt_Email, edt_City;
    String str_Name, str_Password, str_RePassword, str_Email, str_City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        register = (Button) findViewById(R.id.signup);
        signin = (TextView) findViewById(R.id.signin);
        edt_Name = (EditText) findViewById(R.id.txtName);
        edt_Password = (EditText) findViewById(R.id.txtPass);
        edt_RePassword = (EditText) findViewById(R.id.txtCPass);
        edt_City = (EditText) findViewById(R.id.txtCity);
        edt_Email = (EditText) findViewById(R.id.txtEmail);

        register.setOnClickListener(this);
        signin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin:

                // on login button click send to login activity
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
                finish();

                break;
            default:
                str_Name = edt_Name.getText().toString();
                str_Password = edt_Password.getText().toString();
                str_RePassword = edt_RePassword.getText().toString();
                str_City = edt_City.getText().toString();
                str_Email = edt_Email.getText().toString();

                if (str_Name.length() == 0 & str_Password.length() == 0
                        & str_RePassword.length() == 0 & str_City.length() == 0 ) {
                    Toast.makeText(getApplicationContext(),
                            "All fields are mandatory to fill", Toast.LENGTH_LONG)
                            .show();
                } else if (str_Name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Name",
                            Toast.LENGTH_LONG).show();
                } else if (str_Password.length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your Password", Toast.LENGTH_LONG).show();
                } else if (str_RePassword.length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Please Re-enter your Password", Toast.LENGTH_LONG).show();
                } else if (str_Email.length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your Email", Toast.LENGTH_LONG).show();
                } else if (str_Password.contains(str_RePassword) != str_RePassword
                        .contains(str_Password)) {
                    Toast.makeText(getApplicationContext(),
                            "Confirm Password does not match", Toast.LENGTH_LONG)
                            .show();
                } else if (str_City.length() == 0) {

                    Toast.makeText(getApplicationContext(),
                            "Please enter your Address", Toast.LENGTH_LONG)
                            .show();

                } else {
                    Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    Intent signup = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(signup);
                    finish();
                }
                break;
        }
    }
    // on back key press exit the application.

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(SignupActivity.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
