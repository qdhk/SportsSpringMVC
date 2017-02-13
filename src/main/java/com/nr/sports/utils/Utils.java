package com.nr.sports.utils;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by nr on 2017/02/13 0013.
 */

public class Utils {
    /**
     * 加密字符串
     * @return
     */
    public static String encrypt(String original)
    {
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return encrypt(original,md5);
        }
        catch(NoSuchAlgorithmException ex)
        {
            ex.printStackTrace();
            return original;
        }

    }

    /**
     * 加密字符串
     * @param original
     * @param md5
     * @return
     */
    public static String encrypt(String original,MessageDigest md5)
    {
        md5.update(original.getBytes());
        byte[] array = md5.digest();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < array.length; ++j) {
            int b = array[j] & 0xFF;
            if (b < 0x10)
                sb.append('0');
            sb.append(Integer.toHexString(b));
        }
        return sb.toString();
    }
    /**
     * 获得当前日期。
     * 例：2009年03月14日 星期六
     * @return
     */
    public static String getToday() {
        SimpleDateFormat f =
                new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 EEE", Locale.SIMPLIFIED_CHINESE);
        return f.format(new Date(System.currentTimeMillis()));
    }

    /**
     * 将cookie转为map
     * @param cookies
     * @return
     */
    public static Map<String,String> cookiesToMap(Cookie[] cookies)
    {
        if (cookies == null) return null;
        Map<String,String> map = new HashMap<String,String>();
        for(int i=0;i<cookies.length;i++)
        {
            map.put(cookies[i].getName(), cookies[i].getValue());
        }
        return map;
    }
    /**
     * 日期转化为中文大写
     * @param date
     * @return
     */
    public static String getCNDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DAY_OF_MONTH);
        return numToUpper(year) + "年" + monthToUppder(month) + "月" + dayToUppder(day) + "日";
    }

    /**
     * 将数字转化为大写
     * @param num
     * @return
     */
    public static String numToUpper(int num) {
        String u[] = {"〇","一","二","三","四","五","六","七","八","九"};
        char[] str = String.valueOf(num).toCharArray();
        String rstr = "";
        for (int i = 0; i < str.length; i++) {
            rstr = rstr + u[Integer.parseInt(str[i] + "")];
        }
        return rstr;
    }

    /**
     * 月转化为大写
     * @param month
     * @return
     */
    public static String monthToUppder(int month) {
        if(month < 10) {
            return numToUpper(month);
        } else if(month == 10){
            return "十";
        } else {
            return "十" + numToUpper(month - 10);
        }
    }

    /**
     * 日转化为大写
     * @param day
     * @return
     */
    public static String dayToUppder(int day) {
        if(day < 20) {
            return monthToUppder(day);
        } else {
            char[] str = String.valueOf(day).toCharArray();
            if(str[1] == '0') {
                return numToUpper(Integer.parseInt(str[0] + "")) + "十";
            }else {
                return numToUpper(Integer.parseInt(str[0] + "")) + "十" + numToUpper(Integer.parseInt(str[1] + ""));
            }
        }
    }
    /**
     * 去掉文件名中的非法字符
     * @param fileName
     * @return
     */
    public static String fixFileName(String fileName)
    {
        if (StringUtils.isEmpty(fileName))
            return fileName;
        String result = fileName.replaceAll("\r\n", "");
        result = result.replaceAll("\n", "");
        result = result.replaceAll("\\?", "");
        result = result.replaceAll("\\\\", "");
        result = result.replaceAll("\\/", "");
        result = result.replaceAll(":", "");
        result = result.replaceAll("\\*", "");
        result = result.replaceAll("\"", "");
        result = result.replaceAll("<", "");
        result = result.replaceAll(">", "");
        result = result.replaceAll("\\|", "");
        return result;
    }
    /**
     * 删除文件夹下的所有文件
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static void deleteDirectory(File file) throws IOException {
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {// 递归删除文件夹
            if (files[i].isDirectory()) {
                deleteDirectory(files[i]);
                files[i].delete();
            } else {
                files[i].delete();
            }
        }
    }
    /**
     * 输出文本时，将文本中特殊字符进行文本转义
     * @param specialChar
     * @return
     */
    public static String specialCharEscape(String specialChar){
        if (StringUtils.isEmpty(specialChar))
            return specialChar;
        String result = specialChar.replaceAll("<", "&lt;");
        result = result.replaceAll(">", "&gt;");
        return result;
    }
}