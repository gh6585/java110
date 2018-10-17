// IoC 컨테이너 : ClassPathXmlApplicationContext 사용법
// => 스프링 컨테이너의 설정 벙보는 XML 파일에 기록한다.
// => 스프링 설정 파 일을 찾을 때 자바의 classpath에서  설정 파일을 찾는 컨테이너
// 스프링 IoC 컨테이너의 계층도
// BeanFactory 인터페이스
//  |  
//  +-->ApplicationContext 인터페이스
//          |
//          +--> ClassPathXmlApplicationContext  클래스  // xml로 할때
//          |   
//          +--> FileSystemXmlApplicationContext 클래스  //C:드라이브나 전혀다른 곳에있는경우 이거
//          |
//          +--> AnnotationConfigApplicationContext 클래스     // 자바안에 있을떄는 이거 ?
//          |
//          +--> WebApplicationContext 인터페이스 (웹 애플리케이션에서 사용)
//                  |
//                  +--> StaticWebApplicationContext 클래스
//                  |
//                  +--> XmlWebApplicationContext 클래스
//                  | 
//                  +--> AnnotationConfigWebApplicationContext 클래스
 
package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의  경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer =
                new ClassPathXmlApplicationContext("ex02/app-context-1.xml");
        
        
    }
}
