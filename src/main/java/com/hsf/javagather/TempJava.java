package com.hsf.javagather;

import com.hsf.javautils.reflect.ReflectUtil;
import com.hsf.javautils.regex.RegexUtil;

import java.lang.reflect.Field;

public class TempJava {
    public static final String channel = "orgnic";
    public static final int personId = 123;

    public static void main(String[] args) {
        String channelValue = ReflectUtil.getStaticField(TempJava.class, "channel");
        System.out.println("看看渠道: " + channelValue);

        int personId = ReflectUtil.getStaticField(TempJava.class, "personId");
        System.out.println("个人Id: " + personId);
    }


}
