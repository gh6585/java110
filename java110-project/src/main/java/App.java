import java.util.Scanner;

public class App {

    

    public static void main(String[] args) {
       //1) 키보드 입력을 처리할 객체 준비
       Scanner keyin= new Scanner(System.in);
       
       //2) 사용자로부터 회원 정보 입력 받기
       
       while (true) {
       System.out.print("이름?");
       String name = keyin.nextLine();//nextLine 줄단위로 입력받아라 
       //블럭킹 ? 입력받을때까지 기다렸다가 리턴
       
       System.out.print("이메일?");
       String email = keyin.nextLine();
       
       System.out.print("암호?");
       String password = keyin.nextLine();
       
       System.out.printf("%s ,%s, %s\n",name,email,password);
       
       System.out.print("계속하시겠습니까?(y/n)");
       String answer = keyin.nextLine();
       if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
       break;
       
       
       } 
       }
}
