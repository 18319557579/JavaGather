package com.hsf.javagather;

import com.hsf.javautils.regex.RegexRecord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCommentsTest {
    public static void main(String[] args) {
//        String text = "// /*/*sdjfsdf//hwfjjb\nadhbb  //nihao 113";

//        String text = "/*hsdaf//sdf\nnc*/int b = 0;/*你好\n" +
//                "         */\n" +
//                "        /**/";
//
//        String text = "/**\n" +
//                "         根据value找到map中对应的key（找到的第一个）\n" +
//                "         @param map\n" +
//                "         @param value\n" +
//                "         */ System.currentTimeMillis();/**我就是棒\n" +
//                "         *//***的说法说的很好\n" +
//                "         */";

//        String text = "// /*/*sdjfsdf//hwfjjb\\nadhbb  //nihao 113" + "\n" +
//
//                "/*hsdaf//sdf\nnc*/int b = 0;/*你好\n" +
//                "         */\n" +
//                "        /**/" +
//
//                "/**\n" +
//                "         根据value找到map中对应的key（找到的第一个）\n" +
//                "         @param map\n" +
//                "         @param value\n" +
//                "         */ System.currentTimeMillis();/**我就是棒\n" +
//                "         *//***的说法说的很好\n" +
//                "         */";

        String text = "    // /*/*sdjfsdfhwfjjb\n" +
                "    /*\n" +
                "\n" +
                "//     8/\n" +
                "//     士大夫\n" +
                "/////士大夫\n" +
                "//     */\n" +
                "    /** //好的呀\n" +
                "     //使得i伺机待发\n" +
                "     */\n" +
                "    /**和\n" +
                "     sd\n" +
                "     */\n" +
                "    /*什么都可以*/\n" +
                "    /**/\n" +
                "    //099-0-=09、、//ga\n" +
                "    /*hsf8?*/";

//        String text = "/***/";  //识别成了多行注释，验证了单纯让多行注释在先是有问题的

//        String text = "/**//***/";  //识别成了文档注释，验证了单纯让文档注释在先也是有问题的

//        String text = "/**/";


        RegexRecord.findAllComments(text);
    }
}
