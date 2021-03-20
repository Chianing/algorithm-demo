package com.chianing.offer;

/**
 * title: JZ2 替换空格
 * desc:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * ------------------
 * input: We Are Happy
 * output: We%20Are%20Happy
 */
public class JZ2 {

    public static void main(String[] args) {
        String str1 = null;
        String str2 = "";
        String str3 = "We Are Happy ";

        System.out.printf("case1, str1: %s\nresult is: %s%n", str1, replaceBlankWithSign(str1));
        System.out.println("------------------------");
        System.out.printf("case2, str2: %s\nresult is: %s%n", str2, replaceBlankWithSign(str2));
        System.out.println("------------------------");
        System.out.printf("case3, str3: %s\nresult is: %s%n", str3, replaceBlankWithSign(str3));

    }

    public static String replaceBlankWithSign1(String str) {
        return str.replaceAll(" ", "%20");
    }

    public static String replaceBlankWithSign(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return str;
        }

        char[] charArr = str.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char c : charArr) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
