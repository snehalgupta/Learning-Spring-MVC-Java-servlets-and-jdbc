
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.*;  
  
public class MyFilter implements Filter{  
FilterConfig config;  
  
public void init(FilterConfig config) throws ServletException {  
    this.config=config;  
}  
  
public void doFilter(ServletRequest req, ServletResponse resp,  
    FilterChain chain) throws IOException, ServletException {  
      
    PrintWriter out=resp.getWriter();  
          
    String s=config.getInitParameter("construction");  
          
    if(s.equals("yes")){  
         out.print("This page is under construction");  
    }  
    else{  
         chain.doFilter(req, resp);//sends request to next resource  
    }  
          
}  
public void destroy() {}  
}  
