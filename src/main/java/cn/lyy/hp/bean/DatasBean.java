package cn.lyy.hp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lyy on 2019/6/10.
 */
public class DatasBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Az : 0.004575and-0.003025and0.024829and-0.019313and0.036597and-0.027079and0.038627and-0.022117and0.027337and-0.005774and0.005257and0.020568and-0.016196and0.033923and-0.028444and0.041172and-0.032133and-0.039761and0.030934and-0.015532and0.022855

         * Ay : 0.000075and0.004572and0.014538and-0.016069and0.028480and-0.023030and0.037419and-0.016834and0.027602and-0.006401and0.009742and0.007708and-0.007502and0.027453and-0.020623and0.033780and-0.022451and0.028424and-0.017450and0.019708

         * Ax : 0.030095and0.002171and-0.001262and0.023693and-0.029260and0.053862and-0.042748and0.055087and-0.037609and0.038054and-0.012042and0.013043and0.015585and-0.012394and0.042396and-0.038444and0.054456and-0.039761and0.053473and-0.023656

         * Humidity_1 : 0.007889

         * Humidity_2 : -0.002125

         * Pressure_2 : -17826.123669

         * Pressure_1 : 353.641017

         * Time : 20190524111300
         * V_1 : 50.053120

         * V_2 : 48.790932

         * V_3 : 48.396587

         * V_4 : 39.896965

         * V_5 : 49.540520

         * V_6 : 49.764156

         * V_7 : 48.600674

         * V_8 : 49.290657

         * V_9 : 48.324108

         * V_10 : 46.694279

         * V_11 : 46.615124

         * V_12 : 38.365364

         * V_13 : 47.233105

         * V_14 : 47.548771

         * V_15 : 45.510769

         * V_16 : 45.845985

         * stress_xy_2 : -2855.324254

         * stress_y_2 :
         * stress_x_2 : 127.104986

         * stress_z_2 :
         * stress_xz_2 :
         * stress_yz_2 :
         * stress_1 :
         * stress_2 :
         * A_3 :
         * A_2 :
         * A_1 :
         * A_5 :
         * A_4 :
         * Humidity_3 :
         * Humidity_4 :
         * Humidity_5 :
         * T_3 :
         * T_2 :
         * T_! : 29.973526

         * T_5 :
         * T_4 :
         */

        private String Az;
        private String Ay;
        private String Ax;
        private String Humidity_1;
        private String Humidity_2;
        private String Pressure_2;
        private String Pressure_1;
        private String Time;
        private String V_1;
        private String V_2;
        private String V_3;
        private String V_4;
        private String V_5;
        private String V_6;
        private String V_7;
        private String V_8;
        private String V_9;
        private String V_10;
        private String V_11;
        private String V_12;
        private String V_13;
        private String V_14;
        private String V_15;
        private String V_16;
        private String stress_xy_2;
        private String stress_y_2;
        private String stress_x_2;
        private String stress_z_2;
        private String stress_xz_2;
        private String stress_yz_2;
        private String stress_1;
        private String stress_2;
        private String A_3;
        private String A_2;
        private String A_1;
        private String A_5;
        private String A_4;
        private String Humidity_3;
        private String Humidity_4;
        private String Humidity_5;
        private String T_3;
        private String T_2;
        @SerializedName("T_!")
        private String _$T_213; // FIXME check this code
        private String T_5;
        private String T_4;

        public String getAz() {
            return Az;
        }

        public void setAz(String Az) {
            this.Az = Az;
        }

        public String getAy() {
            return Ay;
        }

        public void setAy(String Ay) {
            this.Ay = Ay;
        }

        public String getAx() {
            return Ax;
        }

        public void setAx(String Ax) {
            this.Ax = Ax;
        }

        public String getHumidity_1() {
            return Humidity_1;
        }

        public void setHumidity_1(String Humidity_1) {
            this.Humidity_1 = Humidity_1;
        }

        public String getHumidity_2() {
            return Humidity_2;
        }

        public void setHumidity_2(String Humidity_2) {
            this.Humidity_2 = Humidity_2;
        }

        public String getPressure_2() {
            return Pressure_2;
        }

        public void setPressure_2(String Pressure_2) {
            this.Pressure_2 = Pressure_2;
        }

        public String getPressure_1() {
            return Pressure_1;
        }

        public void setPressure_1(String Pressure_1) {
            this.Pressure_1 = Pressure_1;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public String getV_1() {
            return V_1;
        }

        public void setV_1(String V_1) {
            this.V_1 = V_1;
        }

        public String getV_2() {
            return V_2;
        }

        public void setV_2(String V_2) {
            this.V_2 = V_2;
        }

        public String getV_3() {
            return V_3;
        }

        public void setV_3(String V_3) {
            this.V_3 = V_3;
        }

        public String getV_4() {
            return V_4;
        }

        public void setV_4(String V_4) {
            this.V_4 = V_4;
        }

        public String getV_5() {
            return V_5;
        }

        public void setV_5(String V_5) {
            this.V_5 = V_5;
        }

        public String getV_6() {
            return V_6;
        }

        public void setV_6(String V_6) {
            this.V_6 = V_6;
        }

        public String getV_7() {
            return V_7;
        }

        public void setV_7(String V_7) {
            this.V_7 = V_7;
        }

        public String getV_8() {
            return V_8;
        }

        public void setV_8(String V_8) {
            this.V_8 = V_8;
        }

        public String getV_9() {
            return V_9;
        }

        public void setV_9(String V_9) {
            this.V_9 = V_9;
        }

        public String getV_10() {
            return V_10;
        }

        public void setV_10(String V_10) {
            this.V_10 = V_10;
        }

        public String getV_11() {
            return V_11;
        }

        public void setV_11(String V_11) {
            this.V_11 = V_11;
        }

        public String getV_12() {
            return V_12;
        }

        public void setV_12(String V_12) {
            this.V_12 = V_12;
        }

        public String getV_13() {
            return V_13;
        }

        public void setV_13(String V_13) {
            this.V_13 = V_13;
        }

        public String getV_14() {
            return V_14;
        }

        public void setV_14(String V_14) {
            this.V_14 = V_14;
        }

        public String getV_15() {
            return V_15;
        }

        public void setV_15(String V_15) {
            this.V_15 = V_15;
        }

        public String getV_16() {
            return V_16;
        }

        public void setV_16(String V_16) {
            this.V_16 = V_16;
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

        public String getStress_x_2() {
            return stress_x_2;
        }

        public void setStress_x_2(String stress_x_2) {
            this.stress_x_2 = stress_x_2;
        }

        public String getStress_z_2() {
            return stress_z_2;
        }

        public void setStress_z_2(String stress_z_2) {
            this.stress_z_2 = stress_z_2;
        }

        public String getStress_xz_2() {
            return stress_xz_2;
        }

        public void setStress_xz_2(String stress_xz_2) {
            this.stress_xz_2 = stress_xz_2;
        }

        public String getStress_yz_2() {
            return stress_yz_2;
        }

        public void setStress_yz_2(String stress_yz_2) {
            this.stress_yz_2 = stress_yz_2;
        }

        public String getStress_1() {
            return stress_1;
        }

        public void setStress_1(String stress_1) {
            this.stress_1 = stress_1;
        }

        public String getStress_2() {
            return stress_2;
        }

        public void setStress_2(String stress_2) {
            this.stress_2 = stress_2;
        }

        public String getA_3() {
            return A_3;
        }

        public void setA_3(String A_3) {
            this.A_3 = A_3;
        }

        public String getA_2() {
            return A_2;
        }

        public void setA_2(String A_2) {
            this.A_2 = A_2;
        }

        public String getA_1() {
            return A_1;
        }

        public void setA_1(String A_1) {
            this.A_1 = A_1;
        }

        public String getA_5() {
            return A_5;
        }

        public void setA_5(String A_5) {
            this.A_5 = A_5;
        }

        public String getA_4() {
            return A_4;
        }

        public void setA_4(String A_4) {
            this.A_4 = A_4;
        }

        public String getHumidity_3() {
            return Humidity_3;
        }

        public void setHumidity_3(String Humidity_3) {
            this.Humidity_3 = Humidity_3;
        }

        public String getHumidity_4() {
            return Humidity_4;
        }

        public void setHumidity_4(String Humidity_4) {
            this.Humidity_4 = Humidity_4;
        }

        public String getHumidity_5() {
            return Humidity_5;
        }

        public void setHumidity_5(String Humidity_5) {
            this.Humidity_5 = Humidity_5;
        }

        public String getT_3() {
            return T_3;
        }

        public void setT_3(String T_3) {
            this.T_3 = T_3;
        }

        public String getT_2() {
            return T_2;
        }

        public void setT_2(String T_2) {
            this.T_2 = T_2;
        }

        public String get_$T_213() {
            return _$T_213;
        }

        public void set_$T_213(String _$T_213) {
            this._$T_213 = _$T_213;
        }

        public String getT_5() {
            return T_5;
        }

        public void setT_5(String T_5) {
            this.T_5 = T_5;
        }

        public String getT_4() {
            return T_4;
        }

        public void setT_4(String T_4) {
            this.T_4 = T_4;
        }
    }
}

