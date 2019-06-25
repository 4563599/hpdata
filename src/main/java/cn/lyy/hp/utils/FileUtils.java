package cn.lyy.hp.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileUtils {


    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    // accessKey
    private static String accessKeyId = "LTAIYHofvJPpFKPR";
    private static String accessKeySecret = "Ih7zp0m2mKSSR89dmEzdr4POYTvYUs";
    //空间
    private static String bucketName = "hpdata";
    //文件存储目录
    private static String filedir = "images/";

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

    public static String readOSSDat(String fileName) {
        try {
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            OSSObject ossObject = ossClient.getObject(bucketName, fileName);

            // 读取文件内容。
            System.out.println("Object content:");
            InputStream inputStream = ossObject.getObjectContent();
            byte[] getData = readInputStream(inputStream);
            inputStream.read(getData);
            String str = new String(getData);
            System.out.println("打印内容：" + str);
            inputStream.close();
            // 关闭OSSClient。
            ossClient.shutdown();
            return str;
            // 创建OSSClient实例。
//            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
//            OSSObject ossObject = ossClient.getObject(bucketName, fileName);
//
//// 读取文件内容。
//            System.out.println("Object content:");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
//            while (true) {
//                String line = reader.readLine();
//                if (line == null) break;
//
//                System.out.println("\n" + line);
//            }
//// 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
//            reader.close();
//
//// 关闭OSSClient。
//            ossClient.shutdown();
//            return "";
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
