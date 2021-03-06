package com.xgs.androiddemo.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xgs.androiddemo.R;

/**
 * Created by W.J on 2018/10/9.
 */

public class RectView extends View {
    private Paint mPaint = new Paint();
    private int  mColor;
    public RectView(Context context) {
        super(context);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor = typedArray.getColor(R.styleable.RectView_rect_color,Color.BLUE);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
