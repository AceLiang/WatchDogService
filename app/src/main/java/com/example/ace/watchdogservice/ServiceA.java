package com.example.ace.watchdogservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.ace.watchdogservice.Helper.Dog;
import com.example.ace.watchdogservice.Helper.WatchDog;

/**
 * Created by Liangmingli on 4/12/2016.
 */
public class ServiceA extends Service implements WatchDog.IanrExecption{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private final  static Dog dog = new Dog();
    private WatchDog watchDog ;


    @Override
    public void onCreate() {
        super.onCreate();
        dog.start();
//        watchDog = new WatchDog(dog.getHandler(),this);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        watchDog = new WatchDog(ServiceB.getDog().getHandler(),this);
        watchDog.start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        watchDog.destory();
        watchDog = null ;
    }

    @Override
    public void postExecption() {
        Intent intent = new Intent();
        intent.setClass(this.getApplicationContext(),ServiceA.class);
        startService(intent);
    }

    public static Dog getDog(){
        return dog;
    }
}
