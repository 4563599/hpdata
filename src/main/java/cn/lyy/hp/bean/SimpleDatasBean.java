package cn.lyy.hp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SimpleDatasBean {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String T1;
        private String Humidity1;
        private String Pressure1;
        private String rainfall;
        private String A1;
        private String stressyz1;

        private String Time;


        public String getT1() {
            return T1;
        }

        public void setT1(String t1) {
            T1 = t1;
        }

        public String getHumidity1() {
            return Humidity1;
        }

        public void setHumidity1(String humidity1) {
            Humidity1 = humidity1;
        }

        public String getPressure1() {
            return Pressure1;
        }

        public void setPressure1(String pressure1) {
            Pressure1 = pressure1;
        }

        public String getRainfall() {
            return rainfall;
        }

        public void setRainfall(String rainfall) {
            this.rainfall = rainfall;
        }

        public String getA1() {
            return A1;
        }

        public void setA1(String a1) {
            A1 = a1;
        }

        public String getStressyz1() {
            return stressyz1;
        }

        public void setStressyz1(String stressyz1) {
            this.stressyz1 = stressyz1;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }
    }
}
