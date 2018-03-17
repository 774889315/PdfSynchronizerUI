package com.example.zdl.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZDL on 2018/3/16.
 */

public class MarkItem extends View {

    private String content;

    private String info;

    public MarkItem(Context context) {
        super(context);
    }

    public MarkItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MarkItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        String contentShowed;
        if(content.length() >= 8) contentShowed = content.substring(0, 8) + "...";
        else contentShowed = content;
        String infoShowed;
        if(info.length() >= 20) infoShowed = info.substring(0, 18) + "...";
        else infoShowed = info;

        int height = getHeight();
        int width = getWidth();
        Paint paint = new Paint();
        double d = Math.random();
        paint.setColor(Color.rgb((int)(30 * Math.random()) + 20, (int) (80 * d) + 150, (int) (80 * (1 - d)) + 120));
        canvas.drawRGB(255, 255, 255);
        canvas.drawRect(0, 0, width, 4 * height / 5, paint);
        paint.setColor(Color.BLACK);

        int offX = 50;
        int offY = 70;

        int offX2 = 30;
        int offY2 = 50;

        paint.setTextSize(48);
        canvas.drawText(contentShowed, offX, offY, paint);
        paint.setTextSize(40);
        canvas.drawText(infoShowed, offX2, offY2 + 4 * height / 5, paint);



    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
