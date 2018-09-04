import java.util.Scanner;

public class App { //클래스 변수 main 에서하면 메서드변수 클래스변수는 static 붙여서
    
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static class Member {
       protected String name;
       protected String email;
       protected String password;
       
       
     //인스턴스의 메모리를 다루는 operator(연산자)/=setter/getter=accessor=property=message
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
       
    }
    
    static Member[] members =new Member[100];
    
    static int index =0;
    
    
   //1) 키보드 입력을 처리할 객체 준비
   static Scanner keyin= new Scanner(System.in);
    

    public static void main(String[] args) {
     
       inputMembers();
       printMembers();
      
       
       keyin.close();
    }
    
    static void printMembers() {
        for(int i=0; i< index;i++) {
            System.out.printf("%s ,%s, %s\n"
                    ,members[i].getName(),members[i].getEmail(),members[i].getPassword());
            }
        
    }
    static void inputMembers() {
      //2) 사용자로부터 회원 정보 입력 받기
        while (true) {
            Member m = new Member();
            System.out.print("이름?");
            m.setName(keyin.nextLine());//nextLine 줄단위로 입력받아라 
            //블럭킹 ? 입력받을때까지 기다렸다가 리턴
            
            System.out.print("이메일?");
            m.setEmail(keyin.nextLine());
            
            System.out.print("암호?");
            m.setPassword(keyin.nextLine());
            
            members[index++] = m;
            
            //index++;
            
            System.out.print("계속하시겠습니까?(y/n)");
            String answer = keyin.nextLine();
            if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
            break;
            
            } 
        
    }
}
