package com.f.mylibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.f.mylibrary.R;
import com.f.mylibrary.utils.ActivityUtil;

public class FBTitle extends RelativeLayout {

    private ImageView back;
    private TextView title;
    private TextView right_tv;
    private ImageView right_iv;
    private RelativeLayout bac;

    public FBTitle(Context context, AttributeSet attrs) {
        super(context, attrs);

        View inflate = inflate(getContext(), R.layout.commont_title, this);
        back = (ImageView) inflate.findViewById(R.id.commont_back);
        title = (TextView) inflate.findViewById(R.id.commint_title);
        right_tv = (TextView) inflate.findViewById(R.id.commint_right_tv);
        right_iv = (ImageView) inflate.findViewById(R.id.commint_right_iv);
        bac = (RelativeLayout) inflate.findViewById(R.id.bac);

        onClick();
    }

    private void onClick() {
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.finishNowActivity();
            }
        });
    }

    public ImageView getBack() {
        return back;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getRightTv() {
        return right_tv;
    }

    public ImageView getRightIv() {
        return right_iv;
    }

    public RelativeLayout getBac() {
        return bac;
    }

}
