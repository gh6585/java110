package ex01;

public class Test02 {

    public static void main(String[] args) {
        Car c1 = new CarFactory1().creat("그랜저");

        System.out.println(c1);
    }
}
