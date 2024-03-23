package com.example.mygame;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bmBank;
    static GameEngine gEngine;
    static int SCREEN_W, SCREEN_H;
    static int gr;

    static int VELOCITY_J;
    static int gBetTopAndBotTubes;
    static int nTubes;
    static int tVel;
    static int minTOffY;
    static int maxTOffY;
    static int distBT;
    static SoundBank sBank;
    static Context gameAcitvityContext;
    boolean tVelF = false;
    public static void initialization(Context context){
        setScreenSize(context);
        bmBank = new BitmapBank(context.getResources());
        setGameConstants();
        gEngine = new GameEngine();
        sBank = new SoundBank(context);

    }

    public static SoundBank getsBank(){
        return sBank;
    }

    public static void setGameConstants(){
        AppConstants.gr = 3;
        AppConstants.VELOCITY_J = -40;
        gBetTopAndBotTubes = 600;
        AppConstants.nTubes = 2;
        AppConstants.tVel = 12;
        AppConstants.minTOffY = (int) (AppConstants.gBetTopAndBotTubes / 2.0);
        AppConstants.maxTOffY = AppConstants.SCREEN_H - AppConstants.minTOffY - AppConstants.gBetTopAndBotTubes;
        AppConstants.distBT = AppConstants.SCREEN_W * 3/4;
    }

    public static BitmapBank getBmBank() {
        return bmBank;
    }
    public static GameEngine getgEngine(){
        return gEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_W = width;
        AppConstants.SCREEN_H = height;
    }

}
