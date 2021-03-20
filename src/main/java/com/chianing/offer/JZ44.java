package com.chianing.offer;

/**
 * title: JZ44 	翻转单词顺序列
 * desc:
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * -------------------------
 * input: nowcoder. a am I
 * output: I am a nowcoder.
 */
public class JZ44 {

    public static void main(String[] args) {
        String str1 = "  ";
        String str2 = "  1";
        String str3 = "nowcoder. a am I";

        System.out.printf("case1, str1: %s, result is : %s%n", str1, getReverseStr(str1));
        System.out.println("---------------------");
        System.out.printf("case2, str2: %s, result is : %s%n", str2, getReverseStr(str2));
        System.out.println("---------------------");
        System.out.printf("case3, str3: %s, result is : %s%n", str3, getReverseStr(str3));

    }

    public static String getReverseStr(String str) {
        if (str == null || "".equals(str)
                || !str.contains(" ") || "".equals(str.trim())) {
            return str;
        }

        String[] strArr = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            result.append(strArr[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
