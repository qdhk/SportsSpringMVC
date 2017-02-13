package com.nr.sports.utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nr on 2017/02/13 0013.
 */

/**
 * KeyGeneratorImp，键值格式：2位服务器代码（properties.xml属性值：data.serverCode）+15位日期时间串（2位年份+2位月份+2位月内日期+2位小时+2位分钟+2位秒+3位毫秒）+3序号
 */
@Component
public class KeyGeneratorImpl  {

    /**
     * 生成键值的格式化串：服务器代码+2位年份+2位月份+2位月内日期+2位小时+2位分钟+2位秒+3位毫秒+4位整型的序号
     */
    private static final String KEY_FORMAT = "%1$s%2$ty%2$tm%2$td%2$tH%2$tM%2$tS%2$tL%3$04d";

    /**
     * 序号
     */
    private static int SEQ = 0;

    /**
     * 服务器代码
     */
    private static final String SVR_CODE = "1";

    /**
     * pk的长度
     */
    private static final int KEY_LENGTH = 20;

    public String getKey() throws Exception {
        int s = SEQ++ % 1000;
        String key = String.format(KEY_FORMAT, SVR_CODE, Calendar.getInstance(),s);
        if (key.length() > KEY_LENGTH)
            key = key.substring(key.length() - KEY_LENGTH, key.length());
        else if (key.length() < KEY_LENGTH)
            key = StringUtils.leftPad(key, KEY_LENGTH, '0');
        return key;
    }
    public static void main(String[] args) throws Exception {
        KeyGeneratorImpl k = new KeyGeneratorImpl();
        Set<String> keys = new HashSet<String>();
        for(int i=0;i<20;i++)
        {
            String key = k.getKey();
            if (keys.contains(key))
            {
                System.out.println("key exists:"+key);
            }
            keys.add(key);
            System.out.println(key);
        }
    }
}

