package com.example.ace.watchdogservice.Helper;
import android.os.Handler;

/**
 * Created by Liangmingli on 4/12/2016.
 */
public class WatchDog extends Thread{

    int value = 0 ;


    public interface IanrExecption {
        public void postExecption();
    }

    class Task implements Runnable {

        @Override
        public void run() {
            if (value < 100) {
                value++ ;
            }else {
                value = 0 ;
            }
        }
    }


    private Task watchTask = new Task();

    private Handler dogHandler ;

    private IanrExecption iAnr;

    private boolean idRunning = false;
    public WatchDog(Handler dogHandler, IanrExecption iAnr) {
        this.dogHandler = dogHandler;
        this.iAnr = iAnr;
        idRunning = true ;
    }


    @Override
    public void run() {
        super.run();


        while (idRunning) {
            int temp = value;
            if (dogHandler != null) {
                dogHandler.post(watchTask);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (temp != value){
                continue;
            }else {
                iAnr.postExecption();
            }
        }

    }


    public void destory(){
        idRunning = false;
        Thread.currentThread().interrupt();
        dogHandler = null;
    }
}
