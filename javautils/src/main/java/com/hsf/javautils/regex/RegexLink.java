package com.hsf.javautils.regex;

/**
 * 完全匹配: 输入串要和正则完全匹配得上
 * Matcher.matches()
 *
 * {@link com.hsf.javautils.regex.RegexPackaged#isWindowsDir}
 * {@link com.hsf.javautils.regex.RegexPackaged#htmlCouple}
 * {@link com.hsf.javautils.regex.RegexRecord#isIpv4}
 * {@link com.hsf.javautils.regex.RegexRecord#isLegalCarNum}
 * {@link com.hsf.javautils.regex.RegexRecord#isLegalEmail}
 * {@link com.hsf.javautils.regex.RegexRecord#isLegalIDCard}
 * {@link com.hsf.javautils.regex.RegexRecord#isChineseWords}
 * {@link com.hsf.javautils.regex.RegexRecord#passwordValid}
 * {@link com.hsf.javautils.regex.RegexRecord#passwordValid2}
 * {@link com.hsf.javautils.regex.RegexRecord#isComplexString}
 * {@link com.hsf.javautils.regex.RegexRecord#isJavaNumericTypes}
 * {@link com.hsf.javautils.regex.RegexRecord#isAmericanPhoneNumber}
 *
 * 说白了还是Matcher.matches()的封装
 * static Pattern.matches(String regex, CharSequence input) : boolean
 * {@link com.hsf.javautils.regex.RegexPackaged#isWindowsDir}
 */

/**
 * 判断在输入串中是否有正则的内容：无需完全匹配，正则是输入串的一部分即可
 * Matcher.find()
 *
 * {@link com.hsf.javautils.regex.RegexPackaged#startOf}
 * {@link com.hsf.javautils.regex.RegexPackaged#getStrList}
 * {@link com.hsf.javautils.regex.RegexPackaged#camelCaseSplit}
 * {@link com.hsf.javautils.regex.RegexRecord#isLegalWords}
 * {@link com.hsf.javautils.regex.RegexRecord#passwordSecurityLevel}
 */

/**
 * 替换掉匹配上的部分
 * Matcher.replaceFirst()  只替换第一个匹配到的
 * Matcher.replaceAll()  替换所有匹配到的
 *
 * {@link com.hsf.javautils.regex.RegexPackaged#getFileName}
 * {@link com.hsf.javautils.regex.RegexPackaged#toStrike}
 * {@link com.hsf.javautils.regex.RegexRecord#compressSerialRepeatCharacter}
 * {@link com.hsf.javautils.regex.RegexRecord#getNewFileName}
 * {@link com.hsf.javautils.regex.RegexRecord#compressRepeatCharacter}
 */

/**
 * 更多操作的替换：相较于replaceFirst() replaceAll()，可以在要替换时进行更多操作
 * Matcher.appendReplacement() + Matcher.appendTail()
 *
 * {@link com.hsf.javautils.regex.RegexPackaged#capitalization}
 * {@link com.hsf.javautils.regex.RegexPackaged#humping}
 * {@link com.hsf.javautils.regex.RegexPackaged#htmlEscape}
 * {@link com.hsf.javautils.regex.RegexPackaged#htmlUnescape}
 * {@link com.hsf.javautils.regex.RegexRecord#encodedIllegalWords}
 * {@link com.hsf.javautils.regex.RegexRecord#convertDateFormat}
 */

/**
 * 配合start(), end()这些来进行操作
 * Matcher.start() + Matcher.end()
 *
 * {@link com.hsf.javautils.regex.RegexRecord#findAllComments}
 * {@link com.hsf.javautils.regex.RegexRecord#compressRepeatCharacter} 还是用到了reset()
 */

/**
 * 在Java8后，可以使用asPredicate()将正则的模式转为谓词（Predicate），本质是Matcher.find()
 * Pattern.asPredicate()
 *
 * {@link com.hsf.javautils.regex.RegexRecord_Java8#filterContainsNumber}
 * {@link com.hsf.javautils.regex.RegexRecord_Java8#getLengthGreaterThan4Element}
 */

public class RegexLink {
}
