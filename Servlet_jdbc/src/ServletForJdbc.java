

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
 * Servlet implementation class ServletForJdbc
 */
@WebServlet({ "/ServletForJdbc", "/s" })
public class ServletForJdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String user= request.getParameter("user");
		String pass= request.getParameter("pass");
		String full="";
		String ids="";
		//out.println(user+" "+pass);
	    Connection conn=null;
		String s="";
		int c=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","password");
			//out.println("connection establuished :-"+conn);
			s="select * from user_data";
			
			PreparedStatement ps= conn.prepareStatement(s);
			
			
			ResultSet rs=ps.executeQuery();
			
			
			 /*while(rs1.next()){
				 out.print(rs1.getString("PASSWORD"));
			 }*/
			
			while(rs.next()){
			
			
			if(rs.getString("USER_NAME").equals(user)) {
			c=1;
			}
		
			}
			if(c==1){
				String s1="select PASSWORD from user_data where USER_NAME=?";
				PreparedStatement ps1= conn.prepareStatement(s1);
				ps1.setString(1,user);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
				if(rs1.getString("PASSWORD").equals(pass)){
					String s2="select fullname,id from user_data where USER_NAME=?";
					PreparedStatement ps2= conn.prepareStatement(s2);
					ps2.setString(1,user);
					ResultSet rs2=ps2.executeQuery();
					while(rs2.next()){
						full=rs2.getString(1);
						ids=rs2.getString(2);
					}
					request.getSession().setAttribute("ful",full);
					request.getSession().setAttribute("idz",ids);
					response.sendRedirect("myjsp.jsp");
				}
				else out.println("Chutiya password bhul gaya");
				} 
			}
			else out.print("ghanta nai hai");
			
			
		} catch (ClassNotFoundException e) {
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
