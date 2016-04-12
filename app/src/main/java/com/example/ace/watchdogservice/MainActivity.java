package com.example.ace.watchdogservice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ace.watchdogservice.Helper.Dog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Dog dogA = new Dog();
        Dog dogB = new Dog();

        Intent intent = new Intent();
        intent.setClass(this.getApplicationContext(),ServiceA.class);
        startService(intent);


        intent.setClass(this.getApplicationContext(),ServiceB.class);
        startService(intent);
    }
}
