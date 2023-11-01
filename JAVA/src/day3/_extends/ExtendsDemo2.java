package day3._extends;

public class ExtendsDemo2 {
    /*
        子父类中, 出现了方法声明一模一样的方法 (方法名, 参数, 返回值)
                    在创建子类对象, 调用方法的时候, 会优先使用子类的方法逻辑
                    这虽然是就近原则的现象, 但其实是子类的方法, 对父类的方法, 进行了重写操作

        - 方法重写
     */
    public static void main(String[] args) {
        Zi z = new Zi();
        z.method();
        z.show();
    }
}

class Fu {
    int num = 10;

    public void show(){
        System.out.println("Fu...show");
    }
}

class Zi extends Fu {
    int num = 20;

    public void method(){
        System.out.println(num);            // 20
        System.out.println(super.num);      // 10
    }

    public void show(){
        System.out.println("Zi...show");
    }
}
