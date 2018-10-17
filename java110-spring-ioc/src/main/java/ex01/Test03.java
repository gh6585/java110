package ex01;

public class Test03 {

    public static void main(String[] args) {
        CarFactory2 f = new CarFactory2();
        
        Car c1 = CarFactory1.creat("소나타");

        System.out.println(c1);
    }
}
