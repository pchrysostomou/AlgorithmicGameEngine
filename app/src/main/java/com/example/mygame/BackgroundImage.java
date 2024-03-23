package com.example.mygame;

public class BackgroundImage {
    private int bgImageX, bgImageY, bgImageV;
    public BackgroundImage(){
        bgImageX = 0;
        bgImageY =0;
        bgImageV = 3;
    }

    public int getX(){
        return bgImageX;
    }
    //Getter method gor getting the Y-coordinate

    public int getY(){
        return bgImageY;
    }
    public void setX(int backgroundImageX){
       this.bgImageX = backgroundImageX;
    }

    public void setY(int backgroundImageY){
        this.bgImageY = backgroundImageY;
    }
    public int getVelocity(){
        return bgImageV;
    }

}
