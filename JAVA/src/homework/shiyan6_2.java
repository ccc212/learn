package homework;
//利用Runnable接口改上述的程序，使之完成同样的功能，并上机检验。
class DelayRunnable implements Runnable {
    private static int count = 0;
    private int no;
    private int delay;

    public DelayRunnable() {
        count++;
        no = count;
    }
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                delay = (int) (Math.random() * 5000);
                Thread.sleep(delay);
                System.out.println("Thread " + no + " with a delay " + delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class shiyan6_2{
    public static void main(String args[]) {
        DelayRunnable delayRunnable1 = new DelayRunnable();
        DelayRunnable delayRunnable2 = new DelayRunnable();

        Thread thread1 = new Thread(delayRunnable1);
        Thread thread2 = new Thread(delayRunnable2);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread wrong");
        }
    }
}
