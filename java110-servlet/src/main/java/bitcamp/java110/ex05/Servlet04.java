/* 클라이언트가 보낸 데이터 읽기 - GET 요청으로 보낸 데이터
 * 
 */
package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
              HttpServletRequest req
            , HttpServletResponse res) 
                    throws ServletException, IOException {
        // 테스트:
        // => http://localhost:8888/ex05/text4.html
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("GET요청입니다.");
    }
    
    

}

























