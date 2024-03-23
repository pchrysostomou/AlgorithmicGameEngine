package com.example.mygame;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    final SurfaceHolder sHolder;
    boolean isRun;
    long sTime, lTime; //Loop time
    long DEL = 33;


    public GameThread(SurfaceHolder surfaceHolder){
        this.sHolder = surfaceHolder;
        isRun = true;
    }

    @Override
    public void run() {
        while(isRun){
            sTime = SystemClock.uptimeMillis();

            Canvas canvas = sHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (sHolder){
                    AppConstants.getgEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getgEngine().updateAndDrawBird(canvas);
                    AppConstants.getgEngine().updateAndDrawTubes(canvas);
                    sHolder.unlockCanvasAndPost(canvas);
                }
            }
            lTime = SystemClock.uptimeMillis() - sTime;

            if(lTime < DEL)
                try{
                    Thread.sleep(DEL - lTime);
                }catch(InterruptedException e){
                    Log.e("Interrupted", "Interrupted while sleeping");
                }
        }
    }
    public boolean isRun(){
        return isRun;
    }
    public void setIsRunning(Boolean state){
        isRun = state;
    }
}
