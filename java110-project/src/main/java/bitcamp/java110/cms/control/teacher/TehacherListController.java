package bitcamp.java110.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;
@Component
public class TehacherListController {
   
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = App.teachersDao.findAll();
        
        for(Teacher t : list) {
        
        System.out.printf("%s, %s, %s, %s, %d, [%s]\n",
                    t.getName(), 
                    t.getEmail(), 
                    t.getPassword(), 
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
