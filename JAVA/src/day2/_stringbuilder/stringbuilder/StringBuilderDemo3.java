package day2._stringbuilder.stringbuilder;

public class StringBuilderDemo3 {
    /*
        StringBuilder常用成员方法 :

            1. public StringBuilder append(任意类型) : 添加数据, 并返回对象自己

            2. public StringBuilder reverse() : 将缓冲区中的内容, 进行反转

            3. public int length() : 返回长度

            4. public String toString() : 将缓冲区的内容, 以String字符串类型返回
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        // 链式编程: 调用的方法, 返回的结果是对象, 就可以继续向下调用方法
        sb.append("红色").append("绿色").append("蓝色");

        System.out.println(sb);

        // 情况: 我数据在StringBuilder当中, 我要调用的方法, StringBuilder没有, 但是String有
        // 解决: 转换为String, 再调用
        String[] sArr = sb.toString().split("色");

        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }


    }
}
