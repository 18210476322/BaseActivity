package com.example.demobase;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BaseActivity extends FragmentActivity {
	TextView tv_nonet;
	TextView tv_loading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		FrameLayout body = (FrameLayout) findViewById(R.id.body);
		tv_nonet = (TextView) findViewById(R.id.tv_nonet);
		tv_loading = (TextView) findViewById(R.id.tv_loading);
		body.addView(getCustomView(),0);
		initView();
		initData();
	}

	public abstract void initData();

	public abstract void initView();

	public abstract View getCustomView();

	public void hide() {
		tv_loading.setVisibility(View.GONE);
		tv_nonet.setVisibility(View.GONE);
	}
}
