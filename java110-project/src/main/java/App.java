import java.util.Scanner;

public class App {

    

    public static void main(String[] args) {
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords =new String[100];
        
        int index =0;
        
        
       //1) 키보드 입력을 처리할 객체 준비
       Scanner keyin= new Scanner(System.in);
       
       //2) 사용자로부터 회원 정보 입력 받기
       
       while (true) {
       System.out.print("이름?");
       names[index] = keyin.nextLine();//nextLine 줄단위로 입력받아라 
       //블럭킹 ? 입력받을때까지 기다렸다가 리턴
       
       System.out.print("이메일?");
       emails[index] = keyin.nextLine();
       
       System.out.print("암호?");
       passwords[index] = keyin.nextLine();
       
       index++;
       
       System.out.print("계속하시겠습니까?(y/n)");
       String answer = keyin.nextLine();
       if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
       break;
       
       } 
       
       for(int i=0; i< index;i++) {
       System.out.printf("%s ,%s, %s\n",names[i],emails[i],passwords[i]);
       }
       
       keyin.close();
    }
}
