import java.util.Scanner;

public class MangerController {
    static Manager[] Managers =new Manager[100];
    static int ManagerIndex = 0;
    static Scanner keyin= new Scanner(System.in);
    
    static class Manager extends Member {
        protected String tel;
        protected String position;
       
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        
    }
    
    static void inputManagers() {
        //2) 사용자로부터 회원 정보 입력 받기
        while (true) {
            Manager m = new Manager();
            System.out.print("이름?");
            m.setName(keyin.nextLine());//nextLine 줄단위로 입력받아라 
            //블럭킹 ? 입력받을때까지 기다렸다가 리턴

            System.out.print("이메일?");
            m.setEmail(keyin.nextLine());

            System.out.print("암호?");
            m.setPassword(keyin.nextLine());
            
            System.out.println("tel");
            m.setTel(keyin.nextLine());
            
            System.out.println("position)");
            m.setPosition(keyin.nextLine());
            
       

            Managers[ManagerIndex++] = m;

            //index++;

            System.out.print("계속하시겠습니까?(y/n)");
            String answer = keyin.nextLine();
            if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
                break;

        } 

    }
    static void serviceManagerMenu() {
        while(true) {
            System.out.println("manager 관리> ");
            String command =keyin.nextLine();
            if(command.equals("list")) {
                printManagers();
            }else if(command.equals("add")) {
                inputManagers();
            }else if (command.equals("quit")){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    static void printManagers() {
        int count = 0;
        for (Manager s : Managers) {
            if (count++ == ManagerIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %s\n", 
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPosition());
                    
        }
    }
    
}
