package com.huststl.year18.nov.day19;


//正则表达式匹配 难度（hard)
public class Main010 {

    public boolean isMatch(String text,String pattern) {

        //如果都为空则匹配成功
        if (pattern.isEmpty())
            return text.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));

        } else {

            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(text.substring(1), pattern.substring(1));

        }
    }

}
