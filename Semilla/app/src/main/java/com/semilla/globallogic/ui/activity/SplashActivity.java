package com.semilla.globallogic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.semilla.globallogic.R;

import butterknife.BindView;

public class SplashActivity extends AppCompatActivity {

    RelativeLayout vGuestButton;
    RelativeLayout vUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialize();
    }

    private void initialize() {
        vGuestButton = findViewById(R.id.rl_guest_button);
        vUserButton = findViewById(R.id.rl_user_button);

        vGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });

        vUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity(){
        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}
