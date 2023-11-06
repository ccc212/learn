package day4._polymorphism.test;

public class PlatformPaymentImpl implements Payment {
    @Override
    public void pay(double money) {
        System.out.println("通过支付平台支付了:" + money + "元!");
    }
}
