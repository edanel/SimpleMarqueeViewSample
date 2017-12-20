package com.edanelx.simplemarqueeviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.edanelx.simplemarqueeview.SimpleMarqueeView;

import java.util.List;

/**
 * Created by Edanel on 2017/12/20.
 */

public class SimpleMarqueeAdapter implements SimpleMarqueeView.MarqueeViewAdapter {

    private Context mContext;
    private List<ItemData> itemData;

    public SimpleMarqueeAdapter(Context mContext, List<ItemData> itemData) {
        this.mContext = mContext;
        this.itemData = itemData;
    }

    @Override
    public int getCount() {
        return itemData.size();
    }

    @Override
    public View getView(int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.test_item, null, false);
        ImageView imageView = itemView.findViewById(R.id.test_icon);
        TextView top = itemView.findViewById(R.id.test_text_top);
        TextView bottom = itemView.findViewById(R.id.test_text_bottom);
        ItemData data = itemData.get(position);
        itemView.setTag(data);
        imageView.setImageResource(data.getImg());
        top.setText(data.getTag());
        bottom.setText(data.getText());
        return itemView;
    }
}
