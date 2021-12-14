package com.test.util;

public class TranformUtil {

    /**
     * 将DMS的度分秒 GPS描述转换成 DDD 数字经纬度
     * @param longitude 经度
     * @param latitude 纬度
     * @return 经度,纬度
     */
    public static String dmsTranformDdd(String longitude,String latitude){
        Double y = tranformPos(longitude);
        Double x = tranformPos(latitude);

        return y + "," + x;
    }

    public static Double tranformPos(String lng){
        String[] lntArr = lng
                .trim()
                .replace("°", ";")
                .replace("′", ";")
                .replace("'", ";")
                .replace("\"", "")
                .split(";");
        Double result = 0D;
        for (int i = lntArr.length; i >0 ; i--) {
            double v = Double.parseDouble(lntArr[i-1]);
            if(i==1){
                result=v+result;
            }else{
                result=(result+v)/60;
            }
        }
        return result;
    }

}
