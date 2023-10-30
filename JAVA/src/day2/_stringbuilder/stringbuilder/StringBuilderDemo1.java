package day2._stringbuilder.stringbuilder;

public class StringBuilderDemo1 {
    /*
        StringBuilder的作用 : 提高字符串的操作效率

                1. StringBuilder的特点
                2. StringBuilder的构造方法
                3. StringBuilder常用成员方法
                4. 练习
                5. StringBuilder提高效率
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 100000; i++){
            sb.append(i);
        }

        System.out.println(sb);

        long end = System.currentTimeMillis();

        System.out.println(end - start);            // 10

    }

    private static void method() {
        // 获取1970年1月1日0时0分0秒到现在所经历过的毫秒值 (1秒 = 1000毫秒)
        long start = System.currentTimeMillis();

        String s = "";

        for(int i = 1; i <= 100000; i++){
            s += i;
        }

        System.out.println(s);

        long end = System.currentTimeMillis();

        System.out.println(end - start);            // 2804
    }
}
