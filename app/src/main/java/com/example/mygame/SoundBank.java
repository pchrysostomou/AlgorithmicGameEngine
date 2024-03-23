package com.example.mygame;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundBank {

    Context con;
    MediaPlayer swoosh, po, hit, wing;
    public SoundBank(Context context){
        this.con = context;

        po = MediaPlayer.create(context, R.raw.point);
        hit = MediaPlayer.create(context, R.raw.hit);
        wing = MediaPlayer.create(context, R.raw.wing);

    }



    public void playPoint(){
        if(po != null){
            po.start();
        }
    }
    public void playHit(){
        if(hit != null){
            hit.start();
        }
    }
    public void playWing(){
        if(wing != null){
            wing.start();
        }
    }

}
