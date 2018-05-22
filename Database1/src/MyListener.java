
import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
	try{
		System.out.println("Working...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/testpass@localhost");
		ServletContext ctx=arg0.getServletContext();  
		ctx.setAttribute("mycon", con);  
		/*String query="create table emp32(id number(10),name varchar2(40))";
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		
		System.out.println(query);*/
	}catch(Exception e){e.printStackTrace();}
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
