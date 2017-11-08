

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
 * Servlet implementation class Password_Change
 */
@WebServlet("/Password_Change")
public class Password_Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password_Change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out =response.getWriter();
		String user= request.getParameter("usr");
		String new_pass= request.getParameter("passu");
		String new_pass1= request.getParameter("passu1");
		String id1= request.getParameter("id");
		
		//out.println(user+" "+pass);
	    Connection conn=null;
		String s="";
		int c=0;
		int d=0;
		int f=0;
		int k=0;
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
				String s1="select ID from user_data where USER_NAME=?";
				PreparedStatement ps1= conn.prepareStatement(s1);
				ps1.setString(1,user);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
				if(rs1.getString("ID").equals(id1)) d=1;
				}
			}
			if(d==1){
				if(new_pass.equals(new_pass1)){
					f=1;
				}
				 
			}
			if(f==1){
				String s1="update user_data set password=? where user_name=?";
				PreparedStatement ps1= conn.prepareStatement(s1);
				ps1.setString(1,new_pass);
				ps1.setString(2,user);
				 k=ps1.executeUpdate();
				 
			}
			if(k==1){response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "AfterReset.html");}
			else out.print("something is wrong bro ...go and check ma");
			
			
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
