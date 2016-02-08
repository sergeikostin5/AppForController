package com.sergeikostin.appforcontroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View connectButton = findViewById(R.id.button1);
        connectButton.setOnClickListener(this);


        intent = new Intent(this, SecondActivity.class);
    }

    @Override
    public void onClick(View v) {
        startActivity(intent);
    }
}
