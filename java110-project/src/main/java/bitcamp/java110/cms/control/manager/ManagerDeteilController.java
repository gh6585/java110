package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
@Component
public class ManagerDeteilController {

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao){
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.println("조회할 매니저의 이메일?");
        int no =Integer.parseInt(keyIn.nextLine());
        Manager m = managerDao.findByNo(no);
        
        if(m == null) {
            System.out.println("해당 번호의 메니저가 없습니다!");
            return;
        }
            
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("암호: %s\n", m.getPassword());
        System.out.printf("직위: %s\n", m.getPosition());
        System.out.printf("전화: %s\n", m.getTel());
    }

}
