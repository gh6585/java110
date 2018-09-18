package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;
@Component
public class TeacherController {
   
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }



    @RequestMapping("teacher/add")
    public void add(Request request, Response response) {
        
        Teacher t = new Teacher();
        
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setTel(request.getParameter("tel"));
        t.setSubjects(request.getParameter("subject"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        
        teacherDao.insert(t);
        System.out.println("등록하였습니다.");
        
    }
    @RequestMapping("teacher/delete")
    public void delete(Request request,Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if(teacherDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("해당 번호의 학생이 없습니다");
        }
    }
    @RequestMapping("teacher/detail")
    public void detail(Request request, Response response) {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if(t == null) {
            out.println("해당 번호의 강사가 없습니다!");
            return;
        }
        out.printf("이름: %s\n", t.getName());
        out.printf("이메일: %s\n", t.getEmail());
        out.printf("비번: %s\n", t.getPassword());
        out.printf("전화: %s\n", t.getTel());
        out.printf("과목: %s\n", t.getSubjects());
        out.printf("돈: %s\n", t.getPay());
    }
    @RequestMapping("teacher/list")
    public void list(Request request, Response response) {
        PrintWriter out = response.getWriter();
        List<Teacher> list = teacherDao.findAll();
        
        for(Teacher t : list) {
        
        out.printf("%d,%s, %s, %s, %s, %d, %s\n",
                    t.getNo(),
                    t.getName(), 
                    t.getEmail(), 
                    t.getPassword(), 
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }

}
