package com.hsf.javautils.regex;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegexRecord_Java8 {
    /**
     * 过滤得到包含数字的字符串
     */
    public static List<String> filterContainsNumber(List<String> inputStrList) {
        Pattern pattern = Pattern.compile("\\d");  //包含数字
        Predicate<String> predicate = pattern.asPredicate();  //将一个正则表达式模式转换为一个谓词（Predicate），本质是Matcher.find()
        List<String> filteredStrings = inputStrList.stream()  //先将List转为流
                .filter(predicate)  //过滤剩下包含数字的
                .collect(Collectors.toList());
        return filteredStrings;
    }

    //将字符串以空白符进行分割，再得到长度不少于4的元素
    public static List<String> getLengthGreaterThan4Element(String originStr) {
        Pattern pattern = Pattern.compile("\\s+");  //用空内容做分隔符
        Stream<String> stream = pattern.splitAsStream(originStr);

        Pattern pattern1 = Pattern.compile("\\S{4,}");  //包含不少于4个字符
        Predicate<String> predicate = pattern1.asPredicate();  //（本质是find()）
        List<String> filteredStrings = stream.filter(predicate)
                .collect(Collectors.toList());
        return filteredStrings;

//        Stream<String> streamFilter = stream.filter((CharSequence s) -> s.length() > 3);
//        Stream<Number> streamMap = streamFilter.map((CharSequence s) -> {
//            char firstChar = s.charAt(0);
//            int asciiCode =  firstChar;
//            return new Integer(asciiCode);
//        });

//        streamMap.collect();
//        streamMap.forEach(System.out::println);

//                .map(s - > )
//                .forEach(System.out::println);
    }
}
