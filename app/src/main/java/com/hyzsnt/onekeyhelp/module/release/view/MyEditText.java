package com.hyzsnt.onekeyhelp.module.release.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by gao on 2016/12/13.
 */

public class MyEditText extends RelativeLayout {
    private int maxLength=200;
    private  int minLines=5;
    private  Context mContext;
    private EditText et;
    private TextView tv;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        if (attrs!=null) {
            setCustomAttributes(attrs);
        }
        init(context);
    }


    public MyEditText(Context context,int maxlenth) {
        super(context);
        this.mContext=context;
        maxLength=maxlenth;
        init(context);

    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.MyEditText);
        //最大长度
        maxLength = a.getInt(R.styleable.MyEditText_maxlength,200);
        //最小高度
        minLines = a.getInt(R.styleable.MyEditText_minlines, 5);

    }
    public void hint(String s){
        et.setHint(s);
    }
    //初始化
    private void init(Context context) {
        View view = View.inflate(context, R.layout.myedittext, null);
        et = (EditText) view.findViewById(R.id.et);
        et.setMinLines(minLines);
        // et.setInputType(InputType.TYPE_CLASS_TEXT); //输入类型
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)}); //最大输入长度
        tv = (TextView) view.findViewById(R.id.tv);
        int length = et.getText().toString().length();
        tv.setText(length+"/"+maxLength);
        et.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = et.getText().toString().length();
                tv.setText(length+"/"+maxLength);
            }
        });

        addView(view);

    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
    //实现类似于Edittext的方法
    public void setText(String s){
        et.setText(s);
    }
    public Editable getText(){
        return et.getText();
    }
    public void setEndable(boolean flag){
        et.setEnabled(flag);
    }


}
