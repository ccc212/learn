package day10._thread.d9_tz;

public class test {
    public static void main(String[] args) {
        //悲观锁:一上来就加锁，没有安全感。每次只能一个线程进入访问完毕后，再解锁.线程安全,性能较差!
        //乐观锁：一开始不上锁，认为是没有问题的，大家一起跑，等要出现线程安全问题的时候才开始控制。线程安全,性能较好
        MyRunnable target = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }
    }
}
