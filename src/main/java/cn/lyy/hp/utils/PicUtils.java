package cn.lyy.hp.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PicUtils {
    public static int[][] img2color(String imgfile) {
        File file = new File(imgfile);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        int[][] allcolor = new int[height - miny][width - minx];
        for (int j = miny; j < height; j++) {
            for (int i = minx; i < width; i++) {
                int pixel = bi.getRGB(i, j);// 将一个数字转换为RGB数字
                allcolor[j - miny][i - minx] = pixel;
            }
        }
        return allcolor;
    }

    public static Color[][] img3color(String imgfile) {
        File file = new File(imgfile);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        Color[][] allcolor = new Color[height - miny][width - minx];
        for (int j = miny; j < height; j++) {
            for (int i = minx; i < width; i++) {
                int pixel = bi.getRGB(i, j); // 将一个数字转换为RGB数字
                allcolor[j - miny][i - minx] = new Color(pixel);
            }
        }
        return allcolor;
    }
}
