import java.util.Scanner;



public class StudentController {
    
    static Scanner keyin= new Scanner(System.in);
    static Student[] students =new Student[100];
    static int studentIndex = 0;
    
    static class Student extends Member{
        protected String school;
        protected boolean working;//bollean  은 get,set 이 is로됨
        protected String tel; 
        
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        
    }
    
    
     
    
     static void serviceStudentMenu() {
        while(true) {
            System.out.println("학생 관리> ");
            String command =keyin.nextLine();
            if(command.equals("list")) {
                printStudents();
            }else if(command.equals("add")) {
                inputStudents();
            }else if (command.equals("quit")){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    static void inputStudents() {
        //2) 사용자로부터 회원 정보 입력 받기
        while (true) {
            Student m = new Student();
            System.out.print("이름?");
            m.setName(keyin.nextLine());//nextLine 줄단위로 입력받아라 
            //블럭킹 ? 입력받을때까지 기다렸다가 리턴

            System.out.print("이메일?");
            m.setEmail(keyin.nextLine());

            System.out.print("암호?");
            m.setPassword(keyin.nextLine());
            
            System.out.println("최종학력");
            m.setSchool(keyin.nextLine());
            
            System.out.println("재직여부?(ture/false)");
            m.setWorking(Boolean.parseBoolean(keyin.nextLine()));
            
            System.out.println("전화?");
            m.setTel(keyin.nextLine());

            students[studentIndex++] = m;

            //index++;

            System.out.print("계속하시겠습니까?(y/n)");
            String answer = keyin.nextLine();
            if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
                break;

        } 

    }
    static void printStudents() {
        int count =0;
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            System.out.printf("%s ,%s,%s,%s,%b,%s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }

    }
}
