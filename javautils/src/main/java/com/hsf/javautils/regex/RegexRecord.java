package com.hsf.javautils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRecord {
    /**
     * 判断是否为Ipv4的地址，范围是0.0.0.0~255.255.255.255，要考虑不足三位时前面可能补0的情况
     * 结构：^((…)\.){3}(…)$
     * 0?\d{1,2}代表0 ~ 99，包括前面补0的情况
     * 1\d{2}，匹配 "100" 到 "199"
     * 2[0-4]\d，匹配 "200" 到 "249"
     * 25[0-5]，匹配 "250" 到 "255"
     */
    public static boolean isIpv4(String inputStr) {
        return RegexUtil.matches(
                "^((0?\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(0?\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])$",
                inputStr);
    }

    /**
     * 判断是否为中国合法的车牌号
     * 1.首位为省级单位的简称，包括31个: 京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼
     * 2.接着为地级市的代号，常规为A-Z，但是不能为字母I或O
     * 3.接着为车牌的序号，为5-6位的数字0-9或大写字母A-Z，但是不能为字母I或O
     * 4.港澳地区的比较特殊，必须为粤Z开头，结尾为港/澳，中间剩下的序号仅有4位了
     *
     * 因此先考虑非粤的情况，即 [京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}
     * 在粤的情况中，分为非港澳，即 粤[[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}
     * 港澳，即 粤Z[0-9A-Z&&[^IO]]{4}[港澳]
     */
    public static boolean isLegalCarNum(String inputStr) {
        return RegexUtil.matches(
                "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|粤([[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|Z[0-9A-Z&&[^IO]]{4}[港澳])$",
                inputStr);
    }

    /**
     * 判断是否为合法的Email地址
     * 1.电子邮箱组成部分: 用户名@域名
     * 2.用户名由数字和字母构成，至少为1位
     * 3.域名由数字和字母构成，存在多级域名的情况，且至少为2级，用.来分隔，每级域名至少为1位
     */
    public static boolean isLegalEmail(String email) {
        return RegexUtil.matches(
                "^[0-9a-zA-Z]+@[0-9a-zA-Z]+(\\.[0-9a-zA-Z]+)+$",
                email);
    }

    /**
     * 判断是否为合法的身份证id
     * 1.之前的身份证号码为15位，全数字
     * 2.现在的身份证号码位18位，最后一位是校验位，可能为X
     */
    public static boolean isLegalIDCard(String id) {
        return RegexUtil.matches(
                "\\d{17}[\\dX]|\\d{15}",
                id);
    }

    /**
     * 判断是否为中文词语
     * 不能包含中文以外的字符
     */
    public static boolean isChineseWords(String words) {
        return RegexUtil.matches(
                "^[\\u4e00-\\u9fa5]+$",
                words);
    }

    /**/
    /**
     * 找到Java代码中所有的注释、起始位置、结束位置，并判断注释类型
     * 1.单行注释最先判断，从单行注释开始的位置到本行结束都是注释内容
     * 2.由于多行注释是文档注释的真子集，因此先让文档注释判断。但是这处理不了上面这种空的多行注释的情况，因此多加一个第4个字符为非/的判断
     * 3.最后判断多行注释
     *
     * 因为不会出现重叠注释的情况，所以find的下次开始位置为上次注释的结尾位置，
     */
    public static void findAllComments(String inputStr) {
        Pattern pattern = Pattern.compile(
                "//(?<singleLineComments>[\\d\\D]*?)$|" +
                        "/\\*\\*(?:(?!/))(?<documentComments>[\\d\\D]*?)\\*/|" +
                        "/\\*(?<multiLineComments>[\\d\\D]*?)\\*/",
                Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inputStr);

        int startLocation = 0;
        while (matcher.find(startLocation)) {
            System.out.println("Match: " + matcher.group());
            System.out.println("start: " + matcher.start());
            System.out.println("end: " + matcher.end());

            if (matcher.group("singleLineComments") != null) {
                System.out.println("单行注释:" + matcher.group("singleLineComments"));
            } else if (matcher.group("multiLineComments") != null) {
                System.out.println("多行注释:" + matcher.group("multiLineComments"));
            } else if (matcher.group("documentComments") != null) {
                System.out.println("文档注释:" + matcher.group("documentComments"));
            }
            System.out.println("-----------------------------------------------------\n");

            startLocation = matcher.end();
        }
    }

    /**
     * 判断输入串是否合法（当包含非法单词时就不合法，否则合法）
     */
    public static boolean isLegalWords(String inputStr) {
        String huang = "黄|([Hh][Uu][Aa][Nn][Gg])";
        String pian = "片|([Pp][Ii][Aa][Nn])";
        String regex = String.format("[Pp]\\s*[Oo]\\s*[Rr]\\s*[Nn]|((%s)\\s*(%s))", huang, pian);
        System.out.println("得到的正则:" + regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.find()) {
            return false;
        }
        return true;
    }

    /**
     * 将String中关于黄色的内容进行替换
     * 1.英文的黄色内容使用*进行替换，中文的使用#替换
     * 2.多少位的黄色内容就用多少位* #替换
     */
    public static String encodedIllegalWords(String inputStr) {
        String huang = "黄|([Hh][Uu][Aa][Nn][Gg])";
        String pian = "片|([Pp][Ii][Aa][Nn])";
        String regex = String.format("(?<english>[Pp]\\s*[Oo]\\s*[Rr]\\s*[Nn])|(?<chinese>(%s)\\s*(%s))", huang, pian);
        System.out.println("得到的正则:" + regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            System.out.println("英文:" + matcher.group("english"));
            System.out.println("中文:" + matcher.group("chinese"));

            String repalcement = "";
            if (matcher.group("english") != null) {
                StringBuilder repeatedStringBuilder = new StringBuilder();
                for (int i = 0; i < matcher.group("english").length(); i++) {
                    repeatedStringBuilder.append("*");
                }
                repalcement = repeatedStringBuilder.toString();

            } else if (matcher.group("chinese") != null){
                StringBuilder repeatedStringBuilder = new StringBuilder();
                for (int i = 0; i < matcher.group("chinese").length(); i++) {
                    repeatedStringBuilder.append("#");
                }
                repalcement = repeatedStringBuilder.toString();
            }
            matcher.appendReplacement(sb, repalcement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 转换日期格式
     * 1.转换的分割符为3种，并且要前后一致
     * 2.将分割及末尾替换为年、月、日
     */
    public static String convertDateFormat(String inputStr) {
        Pattern pattern = Pattern.compile("\\d{4}(-|/|\\.)\\d{2}\\1\\d{2}");
        Matcher matcher = pattern.matcher(inputStr);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String allMatch = matcher.group(0);  //匹配到的日期
            String separator = matcher.group(1);  //匹配到的分隔符
            System.out.println("全匹配: " + allMatch + ", 分隔符: " + separator);

            char[] replacements = {'年', '月', '日'};
            int replacementIndex = 0;

            StringBuilder sBuilder = new StringBuilder(allMatch);
            //这里匹配了2个分隔符后就退出，完美解决了效率问题
            for (int i = 0; i < sBuilder.length() && replacementIndex < 2; i++) {
                if (String.valueOf(sBuilder.charAt(i)).equals(separator)) {
                    sBuilder.setCharAt(i, replacements[replacementIndex++]);
                }
            }
            sBuilder.append(replacements[replacementIndex]);  //将日拼到末尾

            matcher.appendReplacement(sb, sBuilder.toString());
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    /**
     * 压缩连续的重复字符
     * 空白符不压缩
     */
    public static String compressSerialRepeatCharacter(String inputStr) {
        Pattern pattern = Pattern.compile("(\\S)\\1+");
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.replaceAll("$1");
    }

    /**
     * 压缩重复字符，只保留第一个
     * 空白符不压缩
     */
    public static String compressRepeatCharacter(String inputStr) {
        Pattern pattern = Pattern.compile("(\\S)(.*\\1)+");  //匹配重复出现的字符
        Matcher matcher = pattern.matcher(inputStr);

        int startIndex = 0;  //标记开始查找的index，每次向后移动一个位置
        while (matcher.find(startIndex)) {
            String allMatch = matcher.group(0);
            String separator = matcher.group(1);
            System.out.println("全匹配: " + allMatch + ", 重复字符: " + separator + ", 匹配的开始位置: " + matcher.start());

            //保留第一个字符，其他的干掉
            String afterReplace = separator + allMatch.replaceAll(separator, "");
            System.out.println("替换后的字符串: " + afterReplace);

            StringBuffer sb = new StringBuffer();
            matcher.appendReplacement(sb, afterReplace);
            matcher.appendTail(sb);  //在这一步进行替换
            System.out.println("替换后的串: " + sb.toString());

            startIndex = matcher.start() + 1;
            matcher.reset(inputStr = sb.toString());  //由于每一次都可能是最后一次，因此将本次的结果保存在inputStr中
        }

        return inputStr;
    }
}
