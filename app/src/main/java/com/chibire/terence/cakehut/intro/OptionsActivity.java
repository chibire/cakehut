package com.chibire.terence.cakehut.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chibire.terence.cakehut.MainActivity;
import com.chibire.terence.cakehut.R;

/**
 * Created by root on 4/14/17.
 */

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, register;
    TextView withoutlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        login = (Button) findViewById(R.id.btn_login_option);
        register = (Button) findViewById(R.id.btn_register);
        withoutlogin = (TextView) findViewById(R.id.withoutlogin);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        withoutlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
            case R.id.btn_login_option:

                // on login button click send to login activity

                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
                finish();

                break;

            case R.id.btn_register:

                // on register button click send to register activity

                Intent registeration = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(registeration);
                finish();

                break;

            // proceed without registgration

            default:
                Intent withoutlogin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(withoutlogin);
                finish();
                break;
        }

    }

    // on back key press exit the application.

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(OptionsActivity.this,
                    SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}