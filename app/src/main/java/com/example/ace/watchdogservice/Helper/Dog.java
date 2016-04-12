package com.example.ace.watchdogservice.Helper;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Liangmingli on 4/12/2016.
 */
public class Dog extends Thread {

    Handler handler ;
    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler();
        Looper.loop();

    }

    public Handler getHandler(){
        return handler;
    }
}
