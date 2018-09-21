package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
              ServletRequest req
            , ServletResponse res) 
                    throws ServletException, IOException {
        // 여기에서 ServletRequest와 ServletResponse를
        // HttpServletRequest와 HttpServletResponse로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse ehttpRes = (HttpServletResponse) res;
        
        this.service(httpReq, ehttpRes);//이클래스를 상속받은 자식서 service 를완성하여야하고 그 서비스를 호출해라
    }
    
    public abstract void service(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException;
    


}
