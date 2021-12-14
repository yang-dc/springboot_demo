package com.test.util;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Demo2 {
    public static void main(String[] args) throws JpegProcessingException, IOException, InterruptedException {

        System.out.println("开始加载照片....");
        Thread.sleep(1000);
        File file = new File("C:\\Users\\dell\\Desktop\\d3150089862f9da9de3c2176ff80aac.jpg");

        Metadata metadata = JpegMetadataReader.readMetadata(file);

        Iterator<Directory> dirs = metadata.getDirectories().iterator();

        String latitude = "";
        String longitude = "";

//        Thread.sleep(1000);
//        System.out.println("照片解析中.....");
//        Thread.sleep(1000);
//        for(int i = 3 ; i > 0 ; i--){
//            System.out.println("倒计时:" + i + "秒...");
//            Thread.sleep(1000);
//        }

        while (dirs.hasNext()){

            Directory next = dirs.next();

            Iterator<Tag> tags = next.getTags().iterator();

            while(tags.hasNext()){
                Tag tag = tags.next();

                System.out.println("tag = " + tag);
                //获取我们的纬度信息
                if("GPS Latitude".equals(tag.getTagName())){
                    latitude = tag.getDescription();
                }

                //获取我们的经度信息
                if("GPS Longitude".equals(tag.getTagName())){
                    longitude = tag.getDescription();
                }
            }

        }

        //将我们获取到的经纬度 变成我们可以定位地图的坐标
        String s = TranformUtil.dmsTranformDdd(longitude, latitude);
        System.out.println("你女朋友照片的位置:" + s);

    }
}
