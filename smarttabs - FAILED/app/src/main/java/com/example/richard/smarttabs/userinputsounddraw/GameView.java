package com.example.richard.smarttabs.userinputsounddraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.example.richard.smarttabs.R;

import static android.content.ContentValues.TAG;

/**
 * Created by richard on 27.02.2018.
 */

public class GameView extends View{

    private Bitmap singerArrow;
    private int canvasWidth;
    private int canvasHeight;
    private int singerArrowX = 170;

    public float getSingerArrowY() {
        return singerArrowY;
    }

    public void setSingerArrowY(float singerArrowY) {
        this.singerArrowY = singerArrowY;
    }

    private float singerArrowY;
    private int singerArrowSpeed;
    private int minSingerY;
    private int maxSingerY;
    private int sequenceLenght;
    private Paint score = new Paint();
    private Canvas boardCanvas;
    Paint linePaint = new Paint();

    private boolean touch_flg = false;

    private void init() {
        linePaint.setColor(Color.BLACK);
    }

    public GameView(Context context) {
        super(context);

        singerArrow = BitmapFactory.decodeResource(getResources(), R.drawable.arrow2);


        score.setColor(Color.BLACK);
        score.setTextSize(32);
        score.setTypeface(Typeface.DEFAULT);
        score.setAntiAlias(true);
        linePaint.setColor(Color.BLACK);
//        linePaint.setStrokeWidth(20);  //Paksemaks


    }



    @Override
    protected void onDraw(Canvas canvas) {



        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        boardCanvas = canvas;

        //singerArrow
        minSingerY = singerArrow.getHeight();
        maxSingerY = canvasHeight - singerArrow.getHeight() * 2;
        sequenceLenght = (maxSingerY - minSingerY) / 20;


        if(getSingerArrowY() != -1) {
            boardCanvas.drawBitmap(singerArrow, singerArrowX, maxSingerY + 15 - getSingerArrowY(), null);
            Log.d(TAG, "onDraw: "+ singerArrow);
        }
//        canvas.drawText("punktid" + getSingerArrowY(), 20, 60, score);
        canvas.drawLine(singerArrowX + 15, 0, singerArrowX + 15, canvasHeight, linePaint);
//        singerArrowY += singerArrowSpeed;
//        if(singerArrowY < minSingerY) singerArrowY = minSingerY;
//        if(singerArrowY > maxSingerY) singerArrowY = maxSingerY;
//        singerArrowSpeed += 2;

//
//        if(touch_flg){
//            touch_flg = false;
//            canvas.drawBitmap(singerArrow, singerArrowX, singerArrowY, null);
//        } else {
//            canvas.drawBitmap(singerArrow, singerArrowX, singerArrowY, null);
//        }


    }
//
//    protected void drawOnVoiceChange(int volumeLevel){
//        boardCanvas.drawBitmap(singerArrow, singerArrowX, sequenceLenght * volumeLevel +1, null);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//
//        if(event.getAction() == MotionEvent.ACTION_DOWN){
//            touch_flg = true;
//            singerArrowSpeed = -20;
//        }
//        return true;
//    }
}

