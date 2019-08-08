package cn.lyy.hp.mapper;

import cn.lyy.hp.bean.Data;
import cn.lyy.hp.bean.SimpleDatasBean;

import java.util.List;

public interface DataMapper {
    Data getData();

    SimpleDatasBean getPictures();

    void saveA1_variance(String a1_variance);

    void saveA2_variance(String a2_variance);

    void saveA3_variance(String a3_variance);

    void saveAx_variance(String ax_variance);

    void saveAy_variance(String ay_variance);

    void saveAz_variance(String az_variance);

    void savePressure1_mean(String pressure1_mean);

    void saveT1(String t1);

    void saveT2(String t2);

    void saveT3(String t3);

    void saveT4(String t4);

    void saveT5(String t5);

    void saveHumidity1_mean(String humidity1_mean);

    void saveHumidity2_mean(String humidity2_mean);

    void saveHumidity3_mean(String humidity3_mean);

    void saveHumidity4_mean(String humidity4_mean);

    void saveHumidity5_mean(String humidity5_mean);

    void saveV1_mean(String v1_mean);

    void saveV2_mean(String v2_mean);

    void saveV3_mean(String v3_mean);

    void saveV4_mean(String v4_mean);

    void saveTime(String time);

    void saveV5_mean(String v5_mean);

    void saveV6_mean(String v6_mean);

    void saveV7_mean(String v7_mean);

    void saveV8_mean(String v8_mean);

    void saveV9_mean(String v9_mean);

    void saveV10_mean(String v10_mean);

    void saveV11_mean(String v11_mean);

    void saveV12_mean(String v12_mean);

    void saverainfall_mean(String rainfall_mean);

    void saveilluminance_mean(String illuminance_mean);

    void savedisplacement1_mean(String displacement1_mean);

    void savedisplacement2_mean(String displacement2_mean);

    void saveFormatTime(String formatTime);

    void saveDatas(String A1_variance, String A2_variance, String A3_variance, String Ax_variance, String Ay_variance, String Az_variance, String Pressure1_mean, String T1, String T2, String T3, String T4, String T5, String Humidity1_mean, String Humidity2_mean, String Humidity3_mean, String Humidity4_mean, String Humidity5_mean, String V1_mean, String V2_mean, String V3_mean, String V4_mean, String V5_mean, String V6_mean, String V7_mean, String V8_mean, String V9_mean, String V10_mean, String V11_mean, String V12_mean, String V13_mean, String V14_mean, String V15_mean, String V16_mean, String Rainfall_mean, String Illuminance_mean, String Displacement1_mean, String Displacement2_mean, String Time, String FormatTime);
}
