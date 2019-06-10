package cn.lyy.hp.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileUtils {
    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }


    public static String readDat(String data_url) {
        try {
            URL url = new URL(data_url);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            //得到输入流
            InputStream inputStream = con.getInputStream();

            byte[] getData = readInputStream(inputStream);
            inputStream.read(getData);
            String str = new String(getData);
            System.out.println("打印内容：" + str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
