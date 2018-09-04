import java.util.Scanner;

public class App { //클래스 변수 main 에서하면 메서드변수 클래스변수는 static 붙여서
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords =new String[100];
    
    static int index =0;
    
    
   //1) 키보드 입력을 처리할 객체 준비
   static Scanner keyin= new Scanner(System.in);
    

    public static void main(String[] args) {
    
       
       inputMemvers();
       printMemvers();
      
       
      
       
       keyin.close();
    }
    
    static void printMemvers() {
        for(int i=0; i< index;i++) {
            System.out.printf("%s ,%s, %s\n",names[i],emails[i],passwords[i]);
            }
        
    }
    static void inputMemvers() {
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
        
    }
}
