package homework;
//阅读下列程序，分析并上机检验其功能。
//class DelayThread extends Thread{
//    private static int count=0;
//    private int no;
//    private int delay;
//    public DelayThread(){
//        count++;
//        no=count;
//    }
//    public void run(){
//        try{
//            for (int i=0;i<10;i++){
//                delay=(int)(Math.random()*5000);
//                sleep(delay);
//                System.out.println(“Thread ”+no+” with a delay ”+delay);
//            }
//        }catch(InterruptedException e){}
//    }
//}
//
//public class MyThread{
//    public static void main(String args[]){
//        DelayThread thread1=new DelayThread();
//        DelayThread thread2=new DelayThread();
//        thread1.start();
//        thread2.start();
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//            System.out.println(“Thread wrong”);
//        }
class DelayThread extends Thread{
    private static int count=0;
    private int no;
    private int delay;
    public DelayThread(){
        count++;
        no=count;
    }
    public void run(){
        try{
            for (int i=0;i<10;i++){
                delay=(int)(Math.random()*5000);
                sleep(delay);
                System.out.println("Thread "+no+" with a delay "+delay);
            }
        }catch(InterruptedException e){}
    }
}

public class shiyan6_1 {
    public static void main(String args[]) {
        DelayThread thread1 = new DelayThread();
        DelayThread thread2 = new DelayThread();
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread wrong");
        }
    }
}

