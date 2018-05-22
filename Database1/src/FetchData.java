
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
  
public class FetchData extends HttpServlet {  
      
public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
      
try{  
//Retrieving connection object from ServletContext object  
ServletContext ctx=getServletContext();  
Connection con=(Connection)ctx.getAttribute("mycon");  
  
//retieving data  from emp32 table        
PreparedStatement ps=con.prepareStatement("select * from emp32");
//,  ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
              
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
out.print("<br>"+rs.getString(1)+" "+rs.getString(2));  
}  
              
con.close();  
}catch(Exception e){e.printStackTrace();}  
          
out.close();  
}  
}  
