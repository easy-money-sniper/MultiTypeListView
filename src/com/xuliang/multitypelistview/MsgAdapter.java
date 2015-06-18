package com.xuliang.multitypelistview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MsgAdapter extends BaseAdapter {

	private List<Msg> mList;

	private LayoutInflater mInflater;

	public MsgAdapter(Context context, List<Msg> mList) {
		this.mList = mList;

		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return mList.get(position).getmType();
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return Const.TYPE_COUNT;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		int type = getItemViewType(position);
		Msg mMsg = mList.get(position);
		ImageTextHolder mItHolder = null;
		TextImageHolder mTiHolder = null;
		ImageOnlyHolder mIoHolder = null;
		TextOnlyHolder mToHolder = null;

		if (convertView == null) {
			switch (type) {
			case Const.TYPE_IMAGE_TEXT:
				mItHolder = new ImageTextHolder();
				convertView = mInflater.inflate(R.layout.image_text, null);
				mItHolder.mImageView = (ImageView) convertView
						.findViewById(R.id.image_text_iv);
				mItHolder.mTextView = (TextView) convertView
						.findViewById(R.id.image_text_tv);
				convertView.setTag(mItHolder);
				break;
			case Const.TYPE_TEXT_IMAGE:
				mTiHolder = new TextImageHolder();
				convertView = mInflater.inflate(R.layout.text_image, null);
				mTiHolder.mTextView = (TextView) convertView
						.findViewById(R.id.text_image_tv);
				mTiHolder.mImageView = (ImageView) convertView
						.findViewById(R.id.text_image_iv);
				convertView.setTag(mTiHolder);
				break;
			case Const.TYPE_IMAGE_ONLY:
				mIoHolder = new ImageOnlyHolder();
				convertView = mInflater.inflate(R.layout.image_only, null);
				mIoHolder.mImageView = (ImageView) convertView
						.findViewById(R.id.image_only_iv);
				convertView.setTag(mIoHolder);
				break;
			case Const.TYPE_TEXT_ONLY:
				mToHolder = new TextOnlyHolder();
				convertView = mInflater.inflate(R.layout.text_only, null);
				mToHolder.mTextView = (TextView) convertView
						.findViewById(R.id.text_only_tv);
				convertView.setTag(mToHolder);
				break;
			default:
				break;
			}
		} else {
			switch (type) {
			case Const.TYPE_IMAGE_TEXT:
				mItHolder = (ImageTextHolder) convertView.getTag();
				break;
			case Const.TYPE_TEXT_IMAGE:
				mTiHolder = (TextImageHolder) convertView.getTag();
				break;
			case Const.TYPE_IMAGE_ONLY:
				mIoHolder = (ImageOnlyHolder) convertView.getTag();
				break;
			case Const.TYPE_TEXT_ONLY:
				mToHolder = (TextOnlyHolder) convertView.getTag();
				break;
			default:
				break;
			}
		}
		switch (type) {
		case Const.TYPE_IMAGE_TEXT:
			mItHolder.mImageView.setImageResource(mMsg.getResourceId());
			mItHolder.mTextView.setText(mMsg.getName());
			break;
		case Const.TYPE_TEXT_IMAGE:
			mTiHolder.mTextView.setText(mMsg.getName());
			mTiHolder.mImageView.setImageResource(mMsg.getResourceId());
			break;
		case Const.TYPE_IMAGE_ONLY:
			mIoHolder.mImageView.setImageResource(mMsg.getResourceId());
			break;
		case Const.TYPE_TEXT_ONLY:
			mToHolder.mTextView.setText(mMsg.getName());
			break;
		default:
			break;
		}
		return convertView;
	}

	class ImageTextHolder {
		ImageView mImageView;
		TextView mTextView;
	}

	class TextImageHolder {
		TextView mTextView;
		ImageView mImageView;
	}

	class ImageOnlyHolder {
		ImageView mImageView;
	}

	class TextOnlyHolder {
		TextView mTextView;
	}

}
