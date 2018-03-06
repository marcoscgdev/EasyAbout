package com.marcoscg.easyabout.widgets;

/**
 * Created by marcos on 22/12/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class CircularImageView extends AppCompatImageView {
    private int size;
    private Paint paint;

    public CircularImageView(Context context) {
        super(context, null);
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();
        if (drawable == null) return;
        if (getWidth() == 0 || getHeight() == 0) return;
        Bitmap srcBmp = drawable.getBitmap();
        if (srcBmp == null) return;
        Bitmap image = getSquareBitmap(srcBmp);
        size = canvas.getWidth();
        if (canvas.getHeight() < size)
            size = canvas.getHeight();
        BitmapShader shader = new BitmapShader(Bitmap.createScaledBitmap(image, size, size, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        int circleCenter = size / 2;
        canvas.drawCircle(circleCenter, circleCenter, circleCenter - 1, paint);
    }

    private Bitmap getSquareBitmap(Bitmap srcBmp) {
        if (srcBmp.getWidth() == srcBmp.getHeight()) return srcBmp;
        int dim = Math.min(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBmp);
        float left = srcBmp.getWidth() > dim ? (dim - srcBmp.getWidth()) / 2 : 0;
        float top = srcBmp.getHeight() > dim ? ((dim - srcBmp.getHeight()) / 2) : 0;
        canvas.drawBitmap(srcBmp, left, top, null);
        return dstBmp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else {
            result = size;
        }
        return result;
    }

    private int measureHeight(int measureSpecHeight) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpecHeight);
        int specSize = MeasureSpec.getSize(measureSpecHeight);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else {
            result = size;
        }
        return (result + 2);
    }
}