package com.example.delta_2_task;

import static java.util.Objects.*;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.util.Objects;

public class MainActivity_Layout extends View {

    Paint red_paintbrush_fill,brown_paintbrush_fill,grey_paintbrush_fill,black_paintbrush_fill;
    Paint red_paintbrush_stroke,brown_paintbrush_stroke,grey_paintbrush_stroke,black;
    Bitmap jerry_bm,right_bm,tom_bm,obstacle1_bm,left_bm;

    public int x,y,jerry_x,jerry_y,obstacle1_x,obstacle2_x,obstacle2_y,obstacle_y,y_dir,y2_dir,obstacle3_x,obstacle3_y,tom_x,tom_y,right_x,right_y,left_x,left_y,score;
    public String score1;




    public MainActivity_Layout(Context context) {
        super(context);
        jerry_x=450;
        jerry_y=1400;
        obstacle_y=0;
        obstacle1_x=50;
        obstacle2_x=450;
        obstacle2_y=100;
        y_dir=5;
        y2_dir=2;
        obstacle3_x=750;
        obstacle3_y=300;
        tom_x=520;
        tom_y=1250;
        right_y=1700;
        right_x=625;
        left_x=225;
        left_y=1700;







    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action=event.getAction();
        float x=event.getX();
        float y=event.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                if(x>=right_x && x<right_x+right_bm.getWidth() && y>=right_y && y<right_y+right_bm.getHeight()){
                    if(tom_x==520) {
                        tom_x = 825;
                        jerry_x = 775;
                    }
                    else if(tom_x==150){
                        tom_x=520;
                        jerry_x=470;
                    }
                }
                if(x>=left_x && x<left_x+left_bm.getWidth() && y>=left_y && y<left_y+left_bm.getHeight()){
                    if(tom_x==520){
                        tom_x=150;
                        jerry_x=100;
                    }
                    else if(tom_x==825){
                        tom_x=520;
                        jerry_x=470;
                    }
                }
                break;
        }
        return true;
    }



    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);



        red_paintbrush_fill=new Paint();
        red_paintbrush_fill.setColor(Color.RED);
        red_paintbrush_fill.setStyle(Paint.Style.FILL);
        brown_paintbrush_fill=new Paint();
        brown_paintbrush_fill.setColor(Color.YELLOW);
        brown_paintbrush_fill.setStyle(Paint.Style.FILL);
        grey_paintbrush_fill=new Paint();
        grey_paintbrush_fill.setColor(Color.GRAY);
        grey_paintbrush_fill.setStyle(Paint.Style.FILL);
        black_paintbrush_fill=new Paint();
        black_paintbrush_fill.setColor(Color.BLACK);
        black_paintbrush_fill.setStyle(Paint.Style.FILL);
        red_paintbrush_stroke=new Paint();
        red_paintbrush_stroke.setColor(Color.RED);
        red_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        red_paintbrush_stroke.setStrokeWidth(10);
        brown_paintbrush_stroke=new Paint();
        brown_paintbrush_stroke.setColor(Color.BLUE);
        brown_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        brown_paintbrush_stroke.setStrokeWidth(10);
        grey_paintbrush_stroke=new Paint();
        grey_paintbrush_stroke.setColor(Color.GRAY);
        grey_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        grey_paintbrush_stroke.setStrokeWidth(10);
        black=new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.STROKE);
        black.setStrokeWidth(10);
        x=canvas.getHeight();
        y=canvas.getWidth();
        Rect rectanglebutton=new Rect();
        rectanglebutton.set(0,1600,y,x);
        canvas.drawRect(rectanglebutton,grey_paintbrush_fill);
        Rect lane2=new Rect();
        lane2.set(x/3,0,x/3+20,1600);
        canvas.drawRect(lane2,black_paintbrush_fill);
        Rect lane1=new Rect();
        lane1.set(350,0,370,1600);
        canvas.drawRect(lane1,black_paintbrush_fill);
        left_bm=BitmapFactory.decodeResource(getResources(),R.drawable.left5);
        right_bm=BitmapFactory.decodeResource(getResources(),R.drawable.right1);
        jerry_bm=BitmapFactory.decodeResource(getResources(),R.drawable.jerry1);
        tom_bm=BitmapFactory.decodeResource(getResources(),R.drawable.tom);





        obstacle1_bm = BitmapFactory.decodeResource(getResources(), R.drawable.obstacle1);
        jerry_y=jerry_y-y_dir;
        tom_y=tom_y-y_dir;
        obstacle_y = obstacle_y + y_dir;
        obstacle2_y=obstacle2_y+y_dir;
        obstacle3_y=obstacle3_y+y_dir;
        canvas.drawBitmap(tom_bm,jerry_x,jerry_y,null);
        canvas.drawBitmap(jerry_bm,tom_x,tom_y,null);
        canvas.drawBitmap(obstacle1_bm, obstacle1_x, obstacle_y, null);
        canvas.drawBitmap(obstacle1_bm,obstacle2_x,obstacle2_y,null);
        canvas.drawBitmap(obstacle1_bm,obstacle3_x,obstacle3_y,null);
        canvas.drawBitmap(right_bm,right_x,right_y,null);
        canvas.drawBitmap(left_bm,left_x,left_y,null);
        invalidate();


        if(obstacle_y==1500){
            for(int j=0;j<=500;j=j+5)
                obstacle_y=0+j;
        }
        if(obstacle2_y==1500){
            for(int i=0;i<=100;i++)
                obstacle2_y=100+i;



        }
        if(obstacle3_y==1500){
            for(int k=0;k<=300;k=k+3)
                obstacle3_y=300+k;
        }
        if(jerry_y==75){
            jerry_y=1400;
            tom_y=1250;
            score++;
        }
        score1=String.valueOf(score);
        black.setTextAlign(Paint.Align.CENTER);
        black.setTextSize(100);
        canvas.drawText(score1,520,100,black);










    }



}
