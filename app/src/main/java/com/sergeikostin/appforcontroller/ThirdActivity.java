package com.sergeikostin.appforcontroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sergeikostin on 2/6/16.
 */
public class ThirdActivity extends Activity implements View.OnClickListener {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        View connectButton = findViewById(R.id.button3);
        connectButton.setOnClickListener(this);


        intent = new Intent(this, MainActivity.class);
    }

    @Override
    public void onClick(View v) {
        startActivity(intent);
    }
}
