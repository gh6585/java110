package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
@Component
public class TeacherDetailController {
    
    TeacherDao teacherDao;
   
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.println("조회할 강사의 이메일? ");
        int no = Integer.parseInt(keyIn.nextLine());
        Teacher teacher = teacherDao.findByNo(no);
        
        if(teacher == null) {
            System.out.println("해당 번호의 강사의 정보가 업습니다");
            return;
        }
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화: %s\n", teacher.getTel());
        System.out.printf("시급: %d\n", teacher.getPay());
        System.out.printf("강의과목: %s\n", teacher.getSubjects());
    }

}
