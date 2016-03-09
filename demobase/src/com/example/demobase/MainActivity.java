package com.example.demobase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class MainActivity extends BaseActivity implements OnClickListener {
	FragIndex fragIndex = new FragIndex();
	FragCook fragCook = new FragCook();
	FragOrder fragOrder = new FragOrder();
	FragPerson fragPerson = new FragPerson();

	private Fragment lastFragmengt;

	TextView tv_index;
	TextView tv_cook;
	TextView tv_order;
	TextView tv_person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initData() {
		hide();
		showIndex();
	}

	private void showIndex() {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.fl_content, fragIndex);
		ft.commitAllowingStateLoss();
		lastFragmengt = fragIndex;
	}

	@Override
	public void initView() {
		tv_index = (TextView) findViewById(R.id.tv_index);
		tv_index.setOnClickListener(this);
		tv_cook = (TextView) findViewById(R.id.tv_cook);
		tv_cook.setOnClickListener(this);
		tv_order = (TextView) findViewById(R.id.tv_order);
		tv_order.setOnClickListener(this);
		tv_person = (TextView) findViewById(R.id.tv_person);
		tv_person.setOnClickListener(this);
	}

	@Override
	public View getCustomView() {
		View view = LayoutInflater.from(this).inflate(R.layout.activity_main,
				null);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_index:
			switchFrag(lastFragmengt, fragIndex);
			lastFragmengt = fragIndex;
			break;
		case R.id.tv_cook:
			switchFrag(lastFragmengt, fragCook);
			lastFragmengt = fragCook;
			break;
		case R.id.tv_order:
			switchFrag(lastFragmengt, fragOrder);
			lastFragmengt = fragOrder;
			break;
		case R.id.tv_person:
			switchFrag(lastFragmengt, fragPerson);
			lastFragmengt = fragPerson;
			break;
		}
	}
	
	private void switchFrag(Fragment from,Fragment to){
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		if (!to.isAdded()) {
			ft.hide(from).add(R.id.fl_content, to).commitAllowingStateLoss();
		} else {
			ft.hide(from).show(to).commitAllowingStateLoss();
		}
	}
}
