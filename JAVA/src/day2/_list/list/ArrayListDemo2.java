package day2._list.list;

import java.util.ArrayList;

public class ArrayListDemo2 {
    /*
        ArrayList 常用成员方法 :

            1. 增 :
                    public boolean add(E e) : 将指定的元素添加到此列表的尾部
                    public void add(int index, E element) : 在指定索引位置, 添加对应的元素 (插队)

            2. 删
                    public E remove(int index) : 根据索引做删除, 返回被删除掉的元素
                    public boolean remove(Object o) : 根据元素做删除, 返回是否删除成功的状态

            3. 改
                    public E set(int index, E element) : 修改指定索引位置, 为对应的元素, 返回被覆盖掉的元素

            ------------------------------------------------------------------------------------------
                    以上方法, 返回值通常不做接收

            4. 查
                    public E get(int index)  : 根据索引, 获取集合中的元素
                    public int size()  : 返回集合中元素的个数

     */
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");

        String s = list.get(2);

        System.out.println(s);

        System.out.println(list.size());



    }

    private static void updateMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");

        String result = list.set(1, "李四");

        System.out.println(result);

        System.out.println(list);
    }

    private static void removeMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");

        System.out.println(list);

        boolean flag = list.remove("李四");

        System.out.println(flag);

        System.out.println(list);
    }

    private static void addMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");

        list.add(0, "张三4");

        System.out.println(list);
    }
}
