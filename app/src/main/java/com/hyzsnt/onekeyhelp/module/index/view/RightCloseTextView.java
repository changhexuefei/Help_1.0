package com.hyzsnt.onekeyhelp.module.index.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by gao on 2016/12/20.
 */

public class RightCloseTextView extends TextView {

    public RightCloseTextView(Context context) {
        super(context);
        init();
    }


    public RightCloseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
//        TextView tv_input = (TextView) findViewById(R.id.tv_input);
        ImageView iv_colse = (ImageView) findViewById(R.id.right_close);
        iv_colse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                RightCloseTextView.this.setText("");
            }
        });

    }


}
