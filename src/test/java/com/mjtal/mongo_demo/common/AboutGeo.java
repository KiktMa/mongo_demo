package com.mjtal.mongo_demo.common;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;
import org.junit.Test;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static com.mjtal.mongo_demo.util.MyTools.getCoordinate;

public class AboutGeo {


    @Test
    public void gridCode() throws IOException {
        try {
            File file = new File("D:\\test_tif\\lonlat\\input.txt"); // 创建一个文件对象
            Scanner scanner = new Scanner(file); // 创建一个Scanner对象，用于读取文件
            FileWriter fw = new FileWriter("D:\\test_tif\\lonlat\\out.txt");

            double height = 0;
            int level = 18;
            int count = 1;
            while (scanner.hasNextLine()) { // 判断是否有下一行
                String line = scanner.nextLine(); // 读取下一行
                String[] lonlat = line.toString().split(" ");
                double lon = Double.valueOf(lonlat[2]);
                double lat = Double.valueOf(lonlat[1]);
                String hexCode = GeoSot.INSTANCE.getHexCode(lat, lon, height, level);
                fw.write(count+" "+hexCode+" "+"1"+" "+level+"\n");
                count++;
            }
            scanner.close(); // 关闭Scanner对象
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readTiffBash() throws IOException {
        int count = 1;
        gdal.AllRegister();
        FileWriter fw = new FileWriter("D:\\test_tif\\lonlat\\input.txt");
        Double[] lonlat = null;
        for (int i = 0; i <= 118; i++) {
            for (int j = 0; j <= 122; j++) {
                Dataset dataset = gdal.Open("D:\\test_tif\\18level\\" + i + "_" + j + ".tif", gdalconstConstants.GA_ReadOnly);
                double[] geoTransform = dataset.GetGeoTransform();
                lonlat = getCoordinate(geoTransform[3],geoTransform[0],4326);
                fw.write(count+" "+lonlat[0]+" "+lonlat[1]+" 0"+"\n");
                count++;
            }
        }
        fw.close();
    }

    @Test
    public void readOneTiff() throws IOException {
        gdal.AllRegister();
        FileWriter fw = new FileWriter("D:\\test_tif\\lonlat\\input.txt");
        Double[] lonlat = null;
        Dataset dataset = gdal.Open("D:\\test_tif\\18level\\0_0.tif", gdalconstConstants.GA_ReadOnly);
        double[] geoTransform = dataset.GetGeoTransform();
        lonlat = getCoordinate(geoTransform[3],geoTransform[0],4326);
        fw.write(lonlat[0]+" "+lonlat[1]);
        fw.close();
    }
}
