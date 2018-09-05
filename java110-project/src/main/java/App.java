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
    


    static Student[] students =new Student[100];

    static int index =0;


    //1) 키보드 입력을 처리할 객체 준비
    static Scanner keyin= new Scanner(System.in);


    public static void main(String[] args) {
        while(true) {
        String menu= promptMenu();

        if(menu.equals("1")) {
            serviceStudentMenu();
        }else if (menu.equals("0")){
            System.out.println("안녕히 가세요!");
            break;
        }
        }
        keyin.close();
    }

    private static void serviceStudentMenu() {
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

    private static String promptMenu() {
        //사용자로부터 메뉴를 입력받기
        System.out.println("[메뉴]");
        System.out.println("1.학생관리");
        System.out.println("2.강사관리");
        System.out.println("3.매니저 관리");
        System.out.println("0.종료");

        while(true) {
            System.out.print("명령 번호> ");

            String menu=keyin.nextLine();        
            switch(menu){
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }

        }
    }

    static void printStudents() {
        int count =0;
        for(Student s : students) {
            if(count++ == index)
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

            students[index++] = m;

            //index++;

            System.out.print("계속하시겠습니까?(y/n)");
            String answer = keyin.nextLine();
            if(answer.toLowerCase().equals("n"))//toLower 메소드 호출후 retrun 값으로 eqpuals
                break;

        } 

    }
}
