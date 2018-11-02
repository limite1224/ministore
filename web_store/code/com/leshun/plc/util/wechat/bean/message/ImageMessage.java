package com.leshun.plc.util.wechat.bean.message;

/**
 * Created by caiyida on 2017/4/10.
 */
public class ImageMessage {
    private Image image;

    public class Image {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
