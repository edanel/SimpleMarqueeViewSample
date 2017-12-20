package com.edanelx.simplemarqueeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

/**
 * Created by Edanel on 2017/12/20.
 */

public class SimpleMarqueeView extends ViewFlipper {

    private MarqueeViewAdapter adapter;
    private int duration;
    private int period;

    private OnMarqueeItemClickListener onMarqueeItemClickListener;

    public SimpleMarqueeView(Context context) {
        this(context, null);
    }

    public SimpleMarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SimpleMarqueeView);
            duration = typedArray.getInt(R.styleable.SimpleMarqueeView_duration, 3000);
            period = typedArray.getInt(R.styleable.SimpleMarqueeView_period, 1000);
            typedArray.recycle();
        }
        setAnimation();
    }

    /**
     * 上下替换动画
     */
    private void setAnimation() {
        setFlipInterval(duration);
        //开始动画
        TranslateAnimation translateAnimationIn = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
                TranslateAnimation.RELATIVE_TO_SELF, 1.0f,
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f);
        translateAnimationIn.setDuration(period);
        translateAnimationIn.setFillAfter(false); //动画之后，停留在最后面
        translateAnimationIn.setRepeatMode(0);
        setInAnimation(translateAnimationIn);
        //结束动画
        TranslateAnimation translateAnimationOut = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
                TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
                TranslateAnimation.RELATIVE_TO_SELF, -1.0f);
        translateAnimationOut.setDuration(period);
        translateAnimationIn.setFillAfter(false); //动画之后，停留在最后面
        translateAnimationIn.setRepeatMode(0);
        setOutAnimation(translateAnimationOut);

    }

    public void stopMarquee() {
        stopFlipping();
    }

    public void startMarquee() {
        startFlipping();
    }

    private void setCustomView() {
        if (null == adapter && adapter.getCount() == 0) {
            return;
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            final int position = i;
            adapter.getView(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMarqueeItemClickListener != null) {
                        onMarqueeItemClickListener.onMarqueeItemClick(position, adapter.getView(position));
                    }
                }
            });
            ViewGroup viewGroup = (ViewGroup) adapter.getView(position).getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            addView(adapter.getView(position));
        }
        startFlipping();
    }

    public interface MarqueeViewAdapter {
        int getCount();

        View getView(int position);
    }

    public void setAdapter(MarqueeViewAdapter adapter) {
        this.adapter = adapter;
        setCustomView();
    }

    public void setOnMarqueeItemClickListener(OnMarqueeItemClickListener onMarqueeItemClickListener) {
        this.onMarqueeItemClickListener = onMarqueeItemClickListener;
    }

    public interface OnMarqueeItemClickListener {
        void onMarqueeItemClick(int position, View view);
    }
}
