package com.woofer.commentandreply.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Admin on 2016/5/19.
 */
public class NoTouchLinearLayout extends LinearLayout {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public NoTouchLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NoTouchLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoTouchLinearLayout(Context context) {
        super(context);
    }


    private OnResizeListener mListener;

    public interface OnResizeListener {
        void OnResize();
    }

    public void setOnResizeListener(OnResizeListener l) {
        mListener = l;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {

            return true;
        }
        return super.dispatchKeyEventPreIme(event);
    }

}
