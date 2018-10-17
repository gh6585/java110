// 객체 생성하기 : Spring IoC 컨테이너 사용
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

    public static void main(String[] args) {
        
        // 객체의 생성과 ,소멸 과 의존 객체 주입을 관리하는 
        // bean container(=IoC 컨테이너)생성하기
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext("ex01/app-context.xml");
        
        // IoC 컨테이너에서 객체 꺼내기 
        Car obj = (Car)iocContainer.getBean("c1"); 

        System.out.println(obj);
        
        iocContainer.close();
    }
}
