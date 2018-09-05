import java.util.Scanner;

public class TeacherController {
    
    static Teacher[] teachers =new Teacher[100];
    static int teacherIndex = 0;
    static Scanner keyin= new Scanner(System.in);
    
    static class Teacher extends Member {
        protected String tel;
        protected int pay;
        protected String subjects;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
        
        
    }
    
     static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리> ");
            String command =keyin.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }else if(command.equals("add")) {
                inputTeachers();
            }else if (command.equals("quit")){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    static void printTeachers() {
        int count = 0;
        for (Teacher s : teachers) {
            if (count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n", 
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPay(),
                    s.getSubjects());
        }
    }
    
    
    static void inputTeachers() {
        //2) 사용자로부터 회원 정보 입력 받기
        while (true) {
            Teacher m = new Teacher();
            System.out.print("이름?");
            m.setName(keyin.nextLine());//nextLine 줄단위로 입력받아라 
            //블럭킹 ? 입력받을때까지 기다렸다가 리턴

            System.out.print("이메일?");
            m.setEmail(keyin.nextLine());

            System.out.print("암호?");
            m.setPassword(keyin.nextLine());
            
            System.out.println("전?");
            m.setTel(keyin.nextLine());
            
            System.out.println("시급?)");
            m.setPay(Integer.parseInt(keyin.nextLine()));
            
            System.out.println("전화?");
            m.setSubjects(keyin.nextLine());

            teachers[teacherIndex++] = m;

            //index++;

            System.out.print("계속하시겠습니까?(y/n)");
            String answer = keyin.nextLine();
            if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
                break;

        } 

    }
}
