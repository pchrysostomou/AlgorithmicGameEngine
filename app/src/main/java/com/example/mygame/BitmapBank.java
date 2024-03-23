package com.example.mygame;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap background2, background3;
    Bitmap[] bird;
    Bitmap tubeTop, tubeBottom;
    Bitmap redTubeTop, redTubeBottom;
    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background2 = BitmapFactory.decodeResource(res, R.drawable.background2);
        background3 = BitmapFactory.decodeResource(res, R.drawable.background3);
        background = scaleImage(background);
        background2 = scaleImage(background2);
        background3 = scaleImage(background3);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.bird_frame4);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.tube_bottom);
        redTubeTop = BitmapFactory.decodeResource(res, R.drawable.red_tube_top);
        redTubeBottom = BitmapFactory.decodeResource(res, R.drawable.red_tube_bottom);
    }
    //Return background2 bitmap
    public Bitmap getBackground2(){
        return background2;
    }

    //Return background2 width
    public int getBackground2Width(){
        return background2.getWidth();
    }

    //Return background2 height
    public int getBackground2Height(){
        return background2.getHeight();
    }

    //Return background3 bitmap
    public Bitmap getBackground3(){
        return background3;
    }

    //Return background3 width
    public int getBackground3Width(){
        return background3.getWidth();
    }

    //Return background3 height
    public int getBackground3Height(){
        return background3.getHeight();
    }
    //Return Red top Tube
    public Bitmap getRedTubeTop(){
        return redTubeTop;
    }

    //return red bottom
    public Bitmap getRedTubeBottom(){
        return redTubeBottom;
    }


    //Return Tube-Top Bitmap
    public Bitmap getTubeTop(){
        return tubeTop;
    }

    //Return Tube-Bottom Bitmap
    public Bitmap getTubeBottom(){
        return tubeBottom;
    }

    //Return Tube-width
    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    //Return Tube Height
    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    //return background bitmap
    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRation = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaleWidth = (int) widthHeightRation * AppConstants.SCREEN_H;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth,AppConstants.SCREEN_H,false);

    }


}
