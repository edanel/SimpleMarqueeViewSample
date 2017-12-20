## SimpleMarqueeView

使用 ViewFlipper 实现的简单视图切换控件，可应用于应用内公告、广告等方案。

## 截图

![](https://github.com/edanel/SimpleMarqueeViewSample/raw/master/screenshot.gif)

## 使用

- 属性
  - duration: 翻页时长，默认是 3000ms
  - period: 翻页速度，默认是 1000ms

```xml
<com.edanelx.simplemarqueeview.SimpleMarqueeView
        android:id="@+id/simple_marquee_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:duration="3000"
        app:period="500" />
```

- 数据源使用适配器配置

```java
public class SimpleMarqueeAdapter implements SimpleMarqueeView.MarqueeViewAdapter {
  	
    @Override
    public int getCount() {
        return 0;
    }
  
    @Override
    public View getView(int position) {
       
        return null;
    }
}
```

- 方法

  - startMarquee()  默认自动开启播放
  - stopMarquee()


  - setAdapter()
  - setOnMarqueeItemClickListener()

```java
 ...
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleMarqueeView = findViewById(R.id.simple_marquee_view);
        adapter = new SimpleMarqueeAdapter(this, getData());
        simpleMarqueeView.setAdapter(adapter);
        simpleMarqueeView.setOnMarqueeItemClickListener((position,view) -> {...});
        simpleMarqueeView.startMarquee();
        simpleMarqueeView.stopMarquee();
    }

    private List<ItemData> getData() {
        ...
        return datas;
    }
```

具体可以参考源码上的使用例子

## 参考

[UpMarqueeTextView](https://github.com/dreamlivemeng/UpMarqueeTextView-master)

## 协议

```
MIT License

Copyright (c) 2017 edanelx

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```