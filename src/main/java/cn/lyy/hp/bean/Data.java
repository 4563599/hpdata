package cn.lyy.hp.bean;

public class Data {
    String pic_name;
    String pic_url;
    String time;

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Data(String pic_name, String pic_url, String time) {
        this.pic_name = pic_name;
        this.pic_url = pic_url;
        this.time = time;
    }


}
