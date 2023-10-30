package day2._stringbuilder.test;

import java.util.Scanner;

public class StringBuilderTest1 {
    /*
        需求: 键盘接受一个字符串，程序判断出该字符串是否是对称字符串(回文字符串)，并在控制台打印是或不是
                对称字符串:  123321、111
                非对称字符串: 123123

        思路: 对拿到的字符串进行反转, 反转后的内容, 跟原数据相同, 判定为回文字符串

                String ---> StringBuilder

                                String s = "abc";
                                StringBuilder sb = new StringBuilder(s);

                StringBuilder ---> String

                                String s = sb.toString();
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个对称字符串: ");
        String content = sc.nextLine();

        // 将String转换为StringBuilder, 为了调用内部反转的方法
        StringBuilder sb = new StringBuilder(content);
        sb.reverse();

        // 判断反转后的内容, 和原数据是否相同
        // content : String类型
        // sb : StringBuilder类型
        if (content.equals(sb.toString())) {
            System.out.println("是对称字符串");
        } else {
            System.out.println("不是对称字符串");
        }
    }
}
