import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class DemoServlet extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter pw=res.getWriter();  
  
//creating ServletContext object  
ServletContext context=getServletContext();  
  
//Getting the value of the initialization parameter and printing it  
String driverName=context.getInitParameter("dname");  
pw.println("driver name is="+driverName);  
  
pw.close();  
  
}}  
