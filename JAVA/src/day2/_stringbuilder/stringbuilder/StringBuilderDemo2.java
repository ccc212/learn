package day2._stringbuilder.stringbuilder;

public class StringBuilderDemo2 {
    /*
        StringBuilder的介绍 :

            1. 一个可变的字符序列
            2. StringBuilder是字符串缓冲区, 将其理解是容器, 这个容器可以存储任意数据类型, 但是只要进入到这个容器, 全部变成字符串.

        StringBuilder的构造方法 :

            public StringBuilder() : 创建一个空白的字符串缓冲区(容器), 其初始容量为16个字符
            public StringBuilder(String str) : 创建一个字符串缓冲区(容器), 容器在创建好之后, 就会带有参数的内容
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("abc");

        System.out.println(sb);

    }
}
