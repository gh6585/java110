package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

//일반 주석!

@Component("hello") //()안에 값이없으면 클래스 이름으로
public class HelloController  {

    @RequestMapping
    public void hello(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }


}
