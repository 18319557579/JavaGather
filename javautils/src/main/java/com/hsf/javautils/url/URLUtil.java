package com.hsf.javautils.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtil {
    /**
     * 判断是否为有效URL（如果非有效URL，那么返回null）
     */
    public static boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
