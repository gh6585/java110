package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
  
    @RequestMapping("student/add")
    public void add(ServletRequest request, ServletResponse response) 
            throws Exception {
            
        Student s = new Student();
        
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        
        
        PrintWriter out = response.getWriter();
        if (studentDao.insert(s) > 0) {
            out.println("저장하였습니다.");
        } else {
            out.println("같은 이메일의 학생이 존재합니다.");
        }
    }
    @RequestMapping("student/delete")
    public void delete(ServletRequest request, ServletResponse response) 
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if (studentDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        }else {
            out.println(" 해당 번호의 학생이 없습니다.");
        }
    }
    @RequestMapping("student/detail")
    public void detail(ServletRequest request, ServletResponse response) 
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        Student s = studentDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if(s == null) {
            out.println("해당 번호의 학생 정보가없습니다!");
            return;
        }
        out.printf("이름: %s\n", s.getName());
        out.printf("이메일: %s\n", s.getEmail());
        out.printf("암호: %s\n", s.getPassword());
        out.printf("전화: %s\n", s.getTel());
        out.printf("최종학력: %s\n", s.getSchool());
        out.printf("재직여부: %b\n", s.isWorking());
    }
    @RequestMapping("student/list")
    public void list(ServletRequest request, ServletResponse response) 
            throws Exception {
        PrintWriter out = response.getWriter();
        List<Student> list = studentDao.findAll();
        
        for(Student s : list) {
        out.printf("%d,%s, %s, %s, %s, %b, %s\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        
        }
    }
}
