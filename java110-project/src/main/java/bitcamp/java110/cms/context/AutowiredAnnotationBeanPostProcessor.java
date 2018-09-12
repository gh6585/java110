package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;

@Component
public class AutowiredAnnotationBeanPostProcessor 
        implements BeanPostProcessor{


    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {
        // objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();

        for(Object obj : objList) {
            Method[] methods = obj.getClass().getDeclaredMethods();//클래스를 가져와서 메소드 찾기
            for (Method m : methods) {
                if (!m.isAnnotationPresent(Autowired.class)) continue;//Autowired같붙은 메서드

                // setter 메서드의 파라미터 타입을 알아낸다.
                Class<?> paramType =m.getParameterTypes()[0];

                // 그 파라미터 타입과 일치하는 객체가 objPool에서 꺼낸다.
                Object dependency=beanContainer.getBean(paramType);

                if(dependency == null) continue;

                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨\n",m.getName());
                }catch (Exception e) {}
            }



        }

    }

}