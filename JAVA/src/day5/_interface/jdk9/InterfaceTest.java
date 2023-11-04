package day5._interface.jdk9;

public class InterfaceTest {
    /*
        JDK9接口特性 :
            接口中允许定义私有方法
     */
    public static void main(String[] args) {

    }
}


interface Inter {
    void show();
    void print();

    public static void start(){
        System.out.println("start方法执行...");
        log();
    }

    public static void end(){
        System.out.println("end方法执行...");
        log();
    }

//    private static void log(){
    static void log(){
        System.out.println("日志记录");
    }
}