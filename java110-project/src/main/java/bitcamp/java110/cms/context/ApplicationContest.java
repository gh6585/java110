package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;



public class ApplicationContest {
    HashMap<String,Object>objpool =new HashMap<>();

    public ApplicationContest(String packgeName) throws Exception {
        //패키지 이름을 파일 경로로 바꾼다
        String path = packgeName.replace(".","/");

        //패키지 경로르 가지고 전체 파일 경로를 알아낸다
        File file =Resources.getResourceAsFile(path);
        // System.out.println(file.getAbsolutePath());

        //패키지 폴더에 들어 있는 파일 목록을 알아낸다.
        findClass(file, path);

        //1) 인스턴스 생성
        //해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에
        //objPool에 보관한다


    }
    //objpool에 보관된 객레츨 이름으로 찾아 리턴한다.
    public Object getBean(String name) {
        //objPool 에서 주어진 이름의 객체를 찾아 리턴한다.

        return objpool.get(name);
    }

    private void findClass(File path,String packagePath) throws Exception {
        File[] files= path.listFiles();

        for(File file : files) {
            if(file.isDirectory()) {
                findClass(file,packagePath + "/" + file.getName());
            }else {
                
                        String className = (packagePath+"/"+file.getName())
                        .replace("/",".")
                        .replace(".class","");
                        
                        //1)클래스 이름을 가지고 .class파일을 찾아 메모리에 로딩한다
                       Class<?> clazz = Class.forName(className);
                      
                       //=> 인터페이스인 경우 무시한다.
                       if(clazz.isInterface()) continue;
                       
                       try {
                       
                       //2)로딩된 클래스 정보를 가지고 인스턴스를 생성한다. 
                       //=>먼저 해당 클래스의 생성자 정보를 얻는다.
                       Constructor<?> constructor=clazz.getConstructor();
                       
                       //=>생성자를 가지고 인스턴스를 생성한다.
                       Object instance =constructor.newInstance();
                      
                       //=>이름으로 인스턴스 필드를 찾는다.
                       Field field=clazz.getField("name");
                       
                       //=> "name"필드의 값을 꺼낸다.
                       Object name = field.get(instance);
                       
                      // System.out.println(clazz.getName()+"==>"+ name);
                       
                       //=> "name"필드의 값으로 인스턴스를 objPool에 저장한다.
                       objpool.put((String)name,instance);
                       
                       }catch(Exception e) {
                           e.printStackTrace();
                           System.out.printf("%s 기본 생성자가 없습니다."
                                   ,clazz.getName());
                       }
            }
        }

    }



}