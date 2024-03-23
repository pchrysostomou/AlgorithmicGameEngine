package com.example.mygame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    BackgroundImage bImage;
    Bird bird;
    static int gState;
    ArrayList<Tube> t;
    Random r;
    int score; // Store the score
    int sTube; //Keep track of scoring
    Paint sPaint;

    int lev = 1;
    boolean tVFlag = false;
    public GameEngine() {
        bImage = new BackgroundImage();
        bird = new Bird();
        // 0 = not started
        //1= Playing
        //2 = GameOver
        gState = 0;
        t = new ArrayList<>();
        r = new Random();
        for (int i = 0; i < AppConstants.nTubes; i++) {
            int tubeX = AppConstants.SCREEN_W + i * AppConstants.distBT;
            // Get topTubeOffsetY
            int topTubeOffsetY = AppConstants.minTOffY + r.nextInt(AppConstants.maxTOffY - AppConstants.minTOffY + 1);
            //Tube Objects
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            t.add(tube);
        }
        score = 0;
        sTube = 0;
        sPaint = new Paint();
        sPaint.setColor(Color.BLACK);
        sPaint.setTextSize(100);
        sPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawTubes(Canvas canvas) {
        if (gState == 1) {
            // Update tube velocity based on the level
            if (lev == 2 && !tVFlag) {
                AppConstants.tVel = 18;
                tVFlag = true; // Ensure we don't repeatedly update the velocity
            } else if (lev == 3 && tVFlag) {
                AppConstants.tVel = 20;
                tVFlag = false; // Reset flag for potential future adjustments
            }

            // Existing logic for collision detection and score increment
            if ((t.get(sTube).getTubeX() < bird.getX() - AppConstants.getBmBank().getBirdWidth()) && (t.get(sTube).getTopTubeOffsetY() > bird.getY() || t.get(sTube).getBottomTubeY() < (bird.getY() + AppConstants.getBmBank().getBirdHeight()))) {
                gState = 2;
                // Game Over logic
                AppConstants.getsBank().playHit();
                Context context = AppConstants.gameAcitvityContext;
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("score", score);
                context.startActivity(intent);
                ((Activity) context).finish();
            } else if (t.get(sTube).getTubeX() < bird.getX() - AppConstants.getBmBank().getTubeWidth()) {
                score++;
                sTube++;
                if (sTube > AppConstants.nTubes - 1) {
                    sTube = 0;
                }
                AppConstants.getsBank().playPoint();
            }

            // Tube movement and drawing logic
            for (int i = 0; i < AppConstants.nTubes; i++) {
                if (t.get(i).getTubeX() < -AppConstants.getBmBank().getTubeWidth()) {
                    t.get(i).setTubeX(t.get(i).getTubeX() + AppConstants.nTubes * AppConstants.distBT);
                    int topTubeOffsetY = AppConstants.minTOffY + r.nextInt(AppConstants.maxTOffY - AppConstants.minTOffY + 1);
                    t.get(i).setTopTubeOffsetY(topTubeOffsetY);
                    t.get(i).setTubeColor();
                }
                t.get(i).setTubeX(t.get(i).getTubeX() - AppConstants.tVel);
                // Tube drawing logic
                if (t.get(i).getTubeColor() == 0) {
                    canvas.drawBitmap(AppConstants.getBmBank().getTubeTop(), t.get(i).getTubeX(), t.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBmBank().getTubeBottom(), t.get(i).getTubeX(), t.get(i).getBottomTubeY(), null);
                } else {
                    canvas.drawBitmap(AppConstants.getBmBank().getRedTubeTop(), t.get(i).getTubeX(), t.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBmBank().getRedTubeBottom(), t.get(i).getTubeX(), t.get(i).getBottomTubeY(), null);
                }
            }
            // Display the score
            canvas.drawText("Score:" + score, 0, 110, sPaint);
        }
    }



    public void updateAndDrawBackgroundImage(Canvas canvas) {
        // Check the score and update the level accordingly
        if (score > 4 && score < 8) {
            lev = 2;

        } else if (score >= 8) {
            lev = 3;
            // Similarly, update the background for level 3
            // For example: backgroundImage = AppConstants.getBitmapBank().getLevel3Background();
        }

        if (lev == 1) {
            canvas.drawBitmap(AppConstants.getBmBank().getBackground(), bImage.getX(), bImage.getY(), null);
            if (bImage.getX() < -(AppConstants.getBmBank().getBackgroundWidth() - AppConstants.SCREEN_W)) {
                canvas.drawBitmap(AppConstants.getBmBank().getBackground(), bImage.getX() +
                        AppConstants.getBmBank().getBackgroundWidth(), bImage.getY(), null);
            }
        } else if (lev == 2) {
            canvas.drawBitmap(AppConstants.getBmBank().getBackground2(), bImage.getX(), bImage.getY(), null);
            if (bImage.getX() < -(AppConstants.getBmBank().getBackground2Width() - AppConstants.SCREEN_W)) {
                canvas.drawBitmap(AppConstants.getBmBank().getBackground2(), bImage.getX() +
                        AppConstants.getBmBank().getBackground2Width(), bImage.getY(), null);
            }
        } else if (lev == 3) {
            canvas.drawBitmap(AppConstants.getBmBank().getBackground3(), bImage.getX(), bImage.getY(), null);
            if (bImage.getX() < -(AppConstants.getBmBank().getBackground3Width() - AppConstants.SCREEN_W)) {
                canvas.drawBitmap(AppConstants.getBmBank().getBackground3(), bImage.getX() +
                        AppConstants.getBmBank().getBackground3Width(), bImage.getY(), null);
            }
        }
    }

    public void updateAndDrawBird(Canvas canvas) {
        if (gState == 1) {
            if (bird.getY() < (AppConstants.SCREEN_H - AppConstants.getBmBank().getBirdHeight()) || bird.getVel() < 0) {
                bird.setVel(bird.getVel() + AppConstants.gr);
                bird.setY(bird.getY() + bird.getVel());
            }
        }
        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBmBank().getBird(currentFrame), bird.getX(), bird.getY(), null);
        currentFrame++;
        if (currentFrame > bird.mFrame) {
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
    }


}
