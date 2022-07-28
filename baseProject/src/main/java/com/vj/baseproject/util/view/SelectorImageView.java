package com.vj.baseproject.util.view;


import com.vj.baseproject.R;


public class SelectorImageView extends androidx.appcompat.widget.AppCompatImageView {

    public SelectorImageView(android.content.Context context) {
        super(context);
        init(null);
    }

    public SelectorImageView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(android.util.AttributeSet attrs) {
        if (attrs != null) {
            android.content.res.TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SelectorImageView);
            android.graphics.drawable.Drawable selectedDrawable = a.getDrawable(R.styleable.SelectorImageView_selectedDrawable);
            android.graphics.drawable.Drawable unselectedDrawable = a.getDrawable(R.styleable.SelectorImageView_unselectedDrawable)
            ;
            setImageDrawable(getStateList(selectedDrawable, unselectedDrawable));
            a.recycle();
        }
    }

    public SelectorImageView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private android.graphics.drawable.Drawable getStateList(android.graphics.drawable.Drawable selected, android.graphics.drawable.Drawable unselected) {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selected);
        stateListDrawable.addState(new int[]{-android.R.attr.state_selected}, unselected);
        stateListDrawable.addState(android.util.StateSet.WILD_CARD, unselected);
        return stateListDrawable;

    }
}