package com.xuliang.multitypelistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mListView;
	private MsgAdapter mAdapter;
	private List<Msg> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	/**
	 * 初始化ListView并设置Adapter
	 */
	private void initView() {
		// TODO Auto-generated method stub
		mListView = (ListView) findViewById(R.id.list_view);
		mAdapter = new MsgAdapter(this, getListData());
		mListView.setAdapter(mAdapter);
	}

	/**
	 * 获取List数据
	 * 
	 * @return
	 */
	private List<Msg> getListData() {
		// TODO Auto-generated method stub
		mList = new ArrayList<Msg>();
		Msg msgImageText = new Msg();
		msgImageText.setmType(Const.TYPE_IMAGE_TEXT);
		msgImageText.setResourceId(R.drawable.ic_launcher);
		msgImageText.setName("easy-money-sniper");
		mList.add(msgImageText);
		
		Msg msgTextImage = new Msg();
		msgTextImage.setmType(Const.TYPE_TEXT_IMAGE);
		msgTextImage.setName("easy-money-sniper");
		msgTextImage.setResourceId(R.drawable.ic_launcher);
		mList.add(msgTextImage);
		
		Msg msgImageOnly = new Msg();
		msgImageOnly.setmType(Const.TYPE_IMAGE_ONLY);
		msgImageOnly.setResourceId(R.drawable.ic_launcher);
		mList.add(msgImageOnly);
		
		Msg msgTextOnly = new Msg();
		msgTextOnly.setmType(Const.TYPE_TEXT_ONLY);
		msgTextOnly.setName("easy-money-sniper");
		msgTextOnly.setResourceId(R.drawable.ic_launcher);
		mList.add(msgTextOnly);
		
		return mList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
