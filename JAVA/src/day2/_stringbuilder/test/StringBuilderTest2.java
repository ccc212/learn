package day2._stringbuilder.test;

public class StringBuilderTest2 {
    /*
        需求:
            定义一个方法, 把int数组中的数据按照指定的格式拼接成一个字符串返回
            调用该方法, 并在控制台输出结果。

            例如: 数组为int[] arr = {1,2,3};
            执行方法后的输出结果为: [1, 2, 3]
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        String result = arrayToString(arr);

        System.out.println(result);

    }

    public static String arrayToString(int[] arr) {

        // 1. 创建StringBuilder, 准备进行拼接
        StringBuilder sb = new StringBuilder("[");

        // 2. 遍历数组, 获取内部元素
        for (int i = 0; i < arr.length - 1; i++) {
            // 3. 将获取到的元素, 拼接到字符串缓冲区
            sb.append(arr[i]).append(", ");
        }

        // 4. 特殊处理最后一个元素
        sb.append(arr[arr.length - 1]).append("]");

        return sb.toString();
    }
}
