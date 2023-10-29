package day1.case2.stringmethod;

public class demo1 {
    public static void main(String[] args) {
        String s1="abc";
        String s2=new String("abc");
        System.out.println(s1==s2);//false  --地址比较
        System.out.println(s1.equals(s2));//true  --内容比较
        String ss1="abc";
        String ss2="ABC";
        System.out.println(ss1.equals(ss2));//false
        System.out.println(ss1.equalsIgnoreCase(s2));//true
    }
}
