package com.example.mygame;

public class Bird {
    private int bX, bY, cFrame, vel;
    public static int mFrame;

    public Bird() {
        bX = AppConstants.SCREEN_W / 2 - AppConstants.getBmBank().getBirdWidth() / 2;
        bY = AppConstants.SCREEN_H / 2 - AppConstants.getBmBank().getBirdHeight() / 2;
        cFrame = 0;
        mFrame = 3;
        vel = 0;
    }
    //Getter method for velocity
    public int getVel(){
        return vel;
    }
    public void setVel(int vel){
        this.vel = vel;
    }

    public int getCurrentFrame() {
        return cFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.cFrame = currentFrame;
    }

    public int getX() {
        return bX;
    }

    public int getY() {
        return bY;
    }

    public void setX(int birdX) {
        this.bX = birdX;
    }

    public void setY(int birdY) {
        this.bY = birdY;

    }
}