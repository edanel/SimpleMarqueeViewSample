package com.edanelx.simplemarqueeviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.edanelx.simplemarqueeview.SimpleMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SimpleMarqueeView simpleMarqueeView;
    private SimpleMarqueeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleMarqueeView = findViewById(R.id.simple_marquee_view);
        adapter = new SimpleMarqueeAdapter(this, getData());
        simpleMarqueeView.setAdapter(adapter);

        simpleMarqueeView.setOnMarqueeItemClickListener(new SimpleMarqueeView.OnMarqueeItemClickListener() {
            @Override
            public void onMarqueeItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<ItemData> getData() {
        List<ItemData> datas = new ArrayList<>();
        datas.add(new ItemData("嘻嘻", "123", R.mipmap.ic_launcher));
        datas.add(new ItemData("哈哈", "1234", R.mipmap.ic_launcher));
        datas.add(new ItemData("啊啊", "12345", R.mipmap.ic_launcher));
        datas.add(new ItemData("方法", "123456", R.mipmap.ic_launcher));
        datas.add(new ItemData("从此", "1234567", R.mipmap.ic_launcher));
        datas.add(new ItemData("就几件", "12345678", R.mipmap.ic_launcher));
        return datas;
    }
}
