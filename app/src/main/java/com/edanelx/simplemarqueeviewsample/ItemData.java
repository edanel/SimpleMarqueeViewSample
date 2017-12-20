package com.edanelx.simplemarqueeviewsample;

/**
 * Created by Edanel on 2017/12/20.
 */

public class ItemData {

    private String tag;
    private String text;
    private int img;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public ItemData(String tag, String text, int img) {
        this.tag = tag;
        this.text = text;
        this.img = img;
    }
}
