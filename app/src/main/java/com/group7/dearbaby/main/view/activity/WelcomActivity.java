package com.group7.dearbaby.main.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.group7.dearbaby.R;

public class WelcomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
startActivity(new Intent(this,MainActivity.class));
    }


}
