package com.example.mygame;


import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;


public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    GameThread gThread;

    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(!gThread.isRun){
            gThread = new GameThread(surfaceHolder);
            gThread.start();
        }else{
            gThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        if(gThread.isRun()){
            gThread.setIsRunning(false);
            boolean retry = true;
            while(retry){
                try{
                    gThread.join();
                    retry=false;
                }catch(InterruptedException e){}
            }

        }
    }

    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gThread = new GameThread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //tap if detected
        if (action == MotionEvent.ACTION_DOWN){
            if(AppConstants.getgEngine().gState == 0) {
                AppConstants.getgEngine().gState = 1;

            }else{
                AppConstants.getsBank().playWing();
            }
            AppConstants.getgEngine().gState = 1;
            AppConstants.getgEngine().bird.setVel(AppConstants.VELOCITY_J);
        }
        return true;
    }
}





