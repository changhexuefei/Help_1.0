package com.hyzsnt.onekeyhelp.module.stroll.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by Administrator on 2016/12/13.
 */

public class CustomExpandaleListView extends ExpandableListView {
	public CustomExpandaleListView(Context context) {
		super(context);
	}

	public CustomExpandaleListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomExpandaleListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

				MeasureSpec.AT_MOST);

		//将重新计算的高度传递回去
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
