package com.aqoong.lib.icontextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconTextView extends LinearLayout {
    private ImageView   vIcon;
    private TextView    vText;

    private String      mText;
    private float       mTextSize;
    private int         mTextColor;

    private Object      mIconRes;
    private int         mOrientaion;

    public IconTextView(Context context) {
        this(context, null);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IconTextView);
        try{
            mText       = ta.getString(R.styleable.IconTextView_text);
            mTextSize   = ta.getFloat(R.styleable.IconTextView_textSize, 13);
            mTextColor  = ta.getColor(R.styleable.IconTextView_textColor, ContextCompat.getColor(getContext(), android.R.color.black));

            mIconRes    = ta.getResourceId(R.styleable.IconTextView_src, 0);
        }finally {
            ta.recycle();
        }
        initView();
    }

    private void initView(){
        Log.d("TEST", "initView() / "+ mOrientaion);
        removeAllViews();
        View parentView = mOrientaion == HORIZONTAL ?
                LayoutInflater.from(getContext()).inflate(R.layout.icontextview_item_horizontal, this, true):
                LayoutInflater.from(getContext()).inflate(R.layout.icontextview_item_vertical, this, true);

        vIcon = parentView.findViewById(R.id.icontextview_icon);
        vText = parentView.findViewById(R.id.icontextview_text);

        setText(mText);
        setTextSize(mTextSize);
        setTextColor(mTextColor);
        setIconSrc(mIconRes);
    }

    public void setText(String text){
        vText.setText(mText = text);
    }

    public void setTextSize(float size){
        vText.setTextSize(mTextSize = size);
    }

    public void setTextColor(int color){
        vText.setTextColor(mTextColor = color);
    }

    /**
     * Integer, Drawable, Bitmap, Uri
     * @param resource
     */
    public void setIconSrc(Object resource){
        try {
            if (resource instanceof Integer) {
                vIcon.setImageResource((int) resource);
            } else if (resource instanceof Drawable) {
                vIcon.setImageDrawable((Drawable) resource);
            } else if (resource instanceof Bitmap) {
                vIcon.setImageBitmap((Bitmap) resource);
            } else if (resource instanceof Uri) {
                vIcon.setImageURI((Uri) resource);
            }
            mIconRes = resource;

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setOrientation(int orientation) {
        Log.d("TEST", "setOrientation() / " + orientation);
        mOrientaion = orientation;
        initView();
    }
}
