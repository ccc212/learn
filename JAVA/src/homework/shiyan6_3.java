package homework;
//编程模拟二个人来排队购买电影票，电影票5元一张，李平拿20元来购票，张红拿5元来购票，售票员只有两张5元的钱。
public class shiyan6_3 {
    private static int ticketPrice = 5;
    private static int cashierMoney = 2 * ticketPrice;
    public static void main(String[] args) {
        Thread liPingThread = new Thread(new TicketPurchase("李平", 20));
        Thread zhangHongThread = new Thread(new TicketPurchase("张红", 5));

        liPingThread.start();
        zhangHongThread.start();
    }
    private static class TicketPurchase implements Runnable {
        private String name;
        private int money;
        public TicketPurchase(String name, int money) {
            this.name = name;
            this.money = money;
        }
        @Override
        public void run() {
            purchaseTicket(name, money);
        }
        private synchronized void purchaseTicket(String name, int money) {
            if (money < ticketPrice) {
                System.out.println(name + "：金额不足，无法购票");
                return;
            }
            if (cashierMoney < ticketPrice) {
                System.out.println(name + "：售票员没有足够的零钱，无法找零");
                return;
            }
            int change = money - ticketPrice;
            System.out.println(name + "：购票成功，找零：" + change + "元");
            cashierMoney += ticketPrice;
        }
    }
}


