package com.hyzsnt.onekeyhelp.module.help.fragment;

import com.baidu.mapapi.map.MapView;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 14369 on 2016/12/12.
 */

public class MapHelpFragment extends BaseFragment {
	@BindView(R.id.help_map)
	MapView mHelpMap;

	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_help_map;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@Override
	public void onPause() {
		super.onPause();
		mHelpMap.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		mHelpMap.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHelpMap.onDestroy();
	}
}
