package ex11.step4;
// AOP : 메서드 호출 앞/뒤에 필터 끼우는 기술

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    // AOP 용어
    // 
    // AOP(Aspect-Oriented Programming)>
    // - 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
    // - 멧서드 호출 앞/뒤/값리턴뒤 에 코드를 삽이할 수 있다.
    // - 일종의 필터를 추가하느 기술이다.
    //
    // AOP 적용 방법
    // - AOP 관련 라이브러리를 추가
    //   - "aspectjweaver" 로 검색한다.
    //   - build.gradle 에 추가한다.
    //   - "gradle eclipse" 실행한다.
    //   - 이클립스 프로젝트 리플래쉬한다.
    // - 필터 역할을 할 클래스 정의
    // - XML 또는 Java Config로 필터를 설정한다.
    // 
    // AOP 용어
    // - Advice     : 필터링 대상이 되는 메서드(join point)의 
    //                호출 앞/뒤에 삽입하는 필터 객체이다.
    //                예) MyAdvice
    //
    // - Join Point : Advice가 삽입될 메서드이다.
    //                예) insert()/update()/delete() 등의 메서드
    //
    // - Pointcut   : Advice를 삽입해야 하는 메서드의 대한 위치 정보이다.
    //                예) execute("* ex11.step4.ServiceImpl.*(..)"
    //
    // - Target Object : Adivice를 삽입해야 하는 메서드를 갖고  있는 클래스이다.
    //                   예) ServiceImpl, MangerDao 등
    //
    // - Aspect     : 어느 pointcut에 어떤 advice를 삽입할 것인지를 가리키는 정보이다.
    //                예) 설정 정보
    //
    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-1.xml");

        // IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);

        Service proxy= (Service)iocContainer.getBean(Service.class);
        proxy.add(); 
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();
    }

    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("--------------------------");

        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        System.out.println("--------------------------");

    }
}








