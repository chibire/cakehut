package com.chibire.terence.cakehut.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chibire.terence.cakehut.MainActivity;
import com.chibire.terence.cakehut.R;

/**
 * Created by root on 4/14/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    String str_UserEmail, str_Password;
    EditText edt_UEmail, edt_Password;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = (Button) findViewById(R.id.signup);
        edt_UEmail = (EditText) findViewById(R.id.txtLogEmail);
        edt_Password = (EditText) findViewById(R.id.txtLogPass);

        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        str_UserEmail = edt_UEmail.getText().toString();
        str_Password = edt_Password.getText().toString();

        if (str_UserEmail.length() == 0 & str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your login email and Password",
                    Toast.LENGTH_LONG).show();
        } else if (str_UserEmail.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your email", Toast.LENGTH_LONG).show();
        } else if (str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Password", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(login);
            finish();
        }
    }
}
