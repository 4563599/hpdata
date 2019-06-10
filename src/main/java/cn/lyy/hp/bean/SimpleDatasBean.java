package cn.lyy.hp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SimpleDatasBean {
    private List<DatasBean.DataBean> data;

    public List<DatasBean.DataBean> getData() {
        return data;
    }

    public void setData(List<DatasBean.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String Humidity_1;
        private String Pressure_1;
        private String Time;
        private String stress_xy_2;
        private String stress_y_2;
        private String A_1;

        public String getHumidity_1() {
            return Humidity_1;
        }

        public void setHumidity_1(String humidity_1) {
            Humidity_1 = humidity_1;
        }

        public String getPressure_1() {
            return Pressure_1;
        }

        public void setPressure_1(String pressure_1) {
            Pressure_1 = pressure_1;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }

        public String getStress_xy_2() {
            return stress_xy_2;
        }

        public void setStress_xy_2(String stress_xy_2) {
            this.stress_xy_2 = stress_xy_2;
        }

        public String getStress_y_2() {
            return stress_y_2;
        }

        public void setStress_y_2(String stress_y_2) {
            this.stress_y_2 = stress_y_2;
        }

        public String getA_1() {
            return A_1;
        }

        public void setA_1(String a_1) {
            A_1 = a_1;
        }
    }
}
