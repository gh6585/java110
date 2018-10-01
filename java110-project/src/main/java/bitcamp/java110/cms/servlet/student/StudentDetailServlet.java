package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        
        Student s = studentDao.findByNo(no);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        
        out.println("<link rel='stylesheet' href='../css/common.css'>");

        out.println("<style>");
        out.println("table, th, td{");
        out.println("border: 1px solid gray;");
        out.println("}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");
        
        // 페이지 머릿말 포함하기
        RequestDispatcher rd =request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<h1>학생 상세정보</h1>");

        if (s == null) {
            out.println("<p>해당 번호의 학생이 없습니다!</p>");
        } else {
            out.println("<table>");
            out.println("<tbody>");
            out.printf("<tr><th>번호</th><td>%d</td></tr>" , s.getNo());
            out.printf("<tr><th>이름</th><td>%s</td></tr>" , s.getName());
            out.printf("<tr><th>이메일</th><td>%s</td></tr>" , s.getEmail());
            out.printf("<tr><th>암호</th><td>%s</td></tr>" , s.getPassword());
            out.printf("<tr><th>전화</th><td>%s</td></tr>" , s.getTel());
            out.printf("<tr><th>일</th><td>%s</td></tr>" , s.isWorking());
            out.printf("<tr><th>학교</th><td>%s</td></tr>" , s.getSchool());
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>\n");
        }
        out.println("<script>");
        out.println("function remove() {");
        out.printf("location.href = 'delete?no=%d'\n",s.getNo());
        out.println("}");
        out.println("</script>");
        
        // 페이지 꼬리말 포함하기
        rd =request.getRequestDispatcher("/footer");
        rd.include(request, response);

        out.println("</body>");
        out.println("</html>");
    }

}
