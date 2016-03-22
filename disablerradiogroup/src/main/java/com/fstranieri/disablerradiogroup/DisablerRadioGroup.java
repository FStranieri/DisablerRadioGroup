package com.fstranieri.disablerradiogroup;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by francescostranieri on 22/03/16.
 */
public class DisablerRadioGroup extends RadioGroup implements RadioGroup.OnCheckedChangeListener {
    Context context;
    OnCheckedChangeListener listener;

    View view;

    int disablerRadio = -1;
    int dependentView = -1;

    public DisablerRadioGroup(Context context) {
        super(context);
        this.context = context;
    }

    public DisablerRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DisablerRadioGroup,
                0, 0);

        try {
            disablerRadio = a.getResourceId(R.styleable.DisablerRadioGroup_disablerRadio, -1);
            dependentView = a.getResourceId(R.styleable.DisablerRadioGroup_dependentViewId, -1);
        } finally {
            a.recycle();
        }
    }

    private void linkView() {
        if (disablerRadio != -1 && dependentView != -1) {
            if (context instanceof Activity)
                this.view = ((Activity) context).getWindow().getDecorView().getRootView().findViewById(dependentView);
        }
        setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (view != null) {
            if (checkedId == disablerRadio)
                view.setEnabled(false);
            else
                view.setEnabled(true);
        }

        if (listener != null)
            listener.onCheckedChanged(group, checkedId);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (view == null)
            linkView();
    }

    public void setRootView(View rootView) {
        this.view = rootView.findViewById(dependentView);
    }

    public void setGroupOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.listener = listener;
    }

    public interface onCheckedChangedListener {
        void onCheckedChanged(RadioGroup group, int checkedId);
    }
}
