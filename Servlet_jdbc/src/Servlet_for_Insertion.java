

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_for_Insertion
 */
@WebServlet("/Servlet_for_Insertion")
public class Servlet_for_Insertion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String u= request.getParameter("u");
		String p= request.getParameter("p");
		String i= request.getParameter("i");
		String f=request.getParameter("f");
		
		//out.println(user+" "+pass);
	    Connection conn=null;
		String s="";
		int c=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","password");
			//out.println("connection establuished :-"+conn);
			s="insert into user_data values(?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(s);
			ps.setString(1,i);
			ps.setString(2,f);
			ps.setString(3,u);
			ps.setString(4,p);
			
		int k =ps.executeUpdate();
		if(k==1) {response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "entry.html");}
		else out.print("bhak");
			
		
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
